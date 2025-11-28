package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class to read configuration values from config.properties file.
 */
public class ConfigReader {

    private static final Properties properties = new Properties();

    // Static block to load properties once when the class is loaded
    static {
        try (FileInputStream input = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            System.err.println("Error loading config.properties file: " + ex.getMessage());
        }
    }

    /**
     * Get the value of a property by key.
     *
     * @param key the property key
     * @return the property value, or null if not found
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Get the value of a property by key with a default value.
     *
     * @param key the property key
     * @param defaultValue the default value to return if key not found
     * @return the property value, or defaultValue if not found
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}