package tests;

import utils.ConfigReader;

public class ConfigTest {

    public static void main(String[] args) {
        ConfigReader configReader = new ConfigReader();

        System.out.println(configReader.getProperty("browser"));
        System.out.println(configReader.getProperty("url"));
        System.out.println(configReader.getProperty("timeout"));

    }
}
