package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {

    private final Properties properties;

    public ConfigReader() {
        properties = new Properties();


        try {
            InputStream input = getClass()
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("config.properties not found");
            }

            properties.load(input);

            String environment = properties.getProperty("environment");
            if (environment == null || environment.isBlank()) {
                throw new RuntimeException("Environment configuration is missing or empty");

            }

            String environmentFile =
                    "environments/" + environment + ".properties";

            InputStream environmentInput = getClass()
                    .getClassLoader()
                    .getResourceAsStream(environmentFile);

            if (environmentInput == null) {
                throw new RuntimeException(
                        "Environment file not found: " + environmentFile);
            }

            properties.load(environmentInput);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new RuntimeException(
                    "Configuration error: " + key + " is missing or empty");
        }

        return value;
    }

    public int getIntProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isBlank()) {
            throw new RuntimeException(
                    "Configuration error: " + key + " is missing or empty"
            );

        }

        try {
            return Integer.parseInt(value);

        } catch (NumberFormatException e) {
            throw new NumberFormatException("integer number required :" + key);
        }


    }
}
