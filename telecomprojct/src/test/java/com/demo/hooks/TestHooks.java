package com.demo.hooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.demo.utils.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestHooks {

	private static final Logger log = LogManager.getLogger(TestHooks.class);
	private WebDriver driver;
	DriverManager drivermanager;
	@Before
	public void scenarioSetup() {
		drivermanager = new DriverManager();
		
		drivermanager.invokebrowser();
		
		String environment = System.getProperty("env");
		
		System.out.println("the env is "+environment);
		
	}
	
	
	
	
	
	
	@After
	public void scenarioTeardown(Scenario scenario) {
		
		// WebDriver driverInstance = drivermanager.getDriver();
		 
		if("sauceLabs".equalsIgnoreCase(System.getProperty("runMode"))) {
			
			boolean isTestPassed = !scenario.isFailed();
			
			 ((JavascriptExecutor) drivermanager.getDriver()).executeScript(
		                "sauce:job-result=" + (isTestPassed ? "passed" : "failed")
		            );
		}
		
		
		DriverManager.quitDriver();
	}
	
}
	

