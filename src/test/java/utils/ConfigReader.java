package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.text.NumberFormat;

public class ConfigReader {

    private Properties properties;

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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public int getIntProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isEmpty()) {
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
