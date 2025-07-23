package com.demo.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.demo.loacators.HomePageLocators;
import com.demo.utils.DriverManager;
import com.demo.utils.SeleniumUtils;

public class HomePage {
	private WebDriver driver;
	private SeleniumUtils seleniumutils;
	private HomePageLocators homeLocator;

	public HomePage(DriverManager driverManager) {
		this.driver = driverManager.getDriver();
		this.seleniumutils = new SeleniumUtils(driverManager);
		homeLocator = new HomePageLocators();
		PageFactory.initElements(driver, homeLocator);

	}

	public void selectProjectbyName(String projectname) {
 
		seleniumutils.clickOnListByText(homeLocator.getItems(), projectname);

	}

}
