package com.demo.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger log = LogManager.getLogger(DriverManager.class);
    private PropertyLoader propertyLoader;
    private String configPath;
    private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    public String runMode;

    public DriverManager() {
        String env = System.getProperty("env");
        if (env == null || env.trim().isEmpty()) {
            env = "qa"; // default to 'qa' if env is not passed
        }
        configPath = Paths.get("src", "test", "resources", "config", env.toLowerCase() + ".properties").toString();
    }

    public WebDriver invokebrowser() {
        if (driver.get() == null) {
            propertyLoader = new PropertyLoader(configPath);
            String homeUrl = propertyLoader.getProperty("url");
            String browser = propertyLoader.getProperty("browser");
            runMode = propertyLoader.getProperty("runMode"); // Add runMode (local/sauceLabs)

            System.out.println("The run mode is "+runMode);
            if ("sauceLabs".equalsIgnoreCase(runMode)) {
                invokeRemoteDriver();  // Run tests on Sauce Labs
            } else {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver.set(new ChromeDriver());
                    log.info("=============== Chrome browser Launched ===============");
                    break;
                case "firefox":
                    driver.set(new FirefoxDriver());
                    log.info("=============== Firefox browser Launched ===============");
                    break;
                default:
                    log.error("Browser not supported: {}", browser);
                    throw new RuntimeException("Browser not supported: " + browser);
            }

           
        }
        
            driver.get().get(homeUrl);
            driver.get().manage().window().maximize();
            setWait();  // Initialize WebDriverWait after the browser is launched
        }
        return driver.get();
    }

    private void setWait() {
        wait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(10))); // Use driver.get() for WebDriverWait
    }

    public WebDriverWait getWait() {
        return wait.get();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            wait.remove(); // Clean up the ThreadLocal for WebDriverWait
        }
    }

    public void invokeRemoteDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase(); // Get browser from system properties
        MutableCapabilities browserOptions;

        switch (browser) {
            case "firefox":
                browserOptions = new FirefoxOptions();
                break;
            case "edge":
                browserOptions = new EdgeOptions();
                break;
            case "chrome":
            default:
                browserOptions = new ChromeOptions();
                break;
        }

        browserOptions.setCapability("platformName", "Windows 11");
        browserOptions.setCapability("browserVersion", "latest");

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-s.padmaraj-43469");
        sauceOptions.put("accessKey", "c0c682d7-d1bc-43f4-96e6-15f72f8bd144");
        sauceOptions.put("build", "selenium-build-3BIH5");
        sauceOptions.put("name", "Login validation");
        
        browserOptions.setCapability("sauce:options", sauceOptions);

        try {
            URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
            driver.set(new RemoteWebDriver(url, browserOptions)); // Store RemoteWebDriver in ThreadLocal
            log.info("=============== Remote WebDriver Started on Sauce Labs with " + browser + " ===============");
        } catch (MalformedURLException e) {
            log.error("Invalid Sauce Labs URL", e);
            throw new RuntimeException(e);
        }

        setWait();
    }

    
	
}
