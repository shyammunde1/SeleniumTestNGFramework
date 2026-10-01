package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataReader {
    private final Properties properties;

    public TestDataReader() {
        properties = new Properties();

        try {
            InputStream input = getClass()
                    .getClassLoader()
                    .getResourceAsStream("testdata/loginData.properties");

            if (input == null) {
                throw new RuntimeException("loginData.properties not found");

            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("failed to load testdata ", e);
        }
    }

    public String getTestData(String key) {
        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new RuntimeException("Test data is missing or empty : " + key);

        }

        return value;

    }


}
