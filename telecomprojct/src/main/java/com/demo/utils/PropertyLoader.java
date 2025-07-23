package com.demo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyLoader {

    private Properties properties = new Properties();

    public PropertyLoader(String filePath) {
        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace(); // Handle the exception appropriately in your code
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
    
/*    private static void loadProperties() {
    	String configPath = Paths.get("src", "test", "resources", "config.properties").toString();
        try (FileInputStream fis = new FileInputStream(configPath)) {
            properties.load(fis);
        } catch (IOException e) {
            log.error("Could not load configuration properties: {}", e.getMessage());
        }*/
	
	
	}
    


