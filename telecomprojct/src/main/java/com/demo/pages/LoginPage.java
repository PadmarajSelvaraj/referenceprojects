package com.demo.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.demo.loacators.LoginPageLocators;
import com.demo.utils.DriverManager;
import com.demo.utils.SeleniumUtils;

public class LoginPage {
	WebDriver driver;
	private SeleniumUtils seleniumutils;
	private LoginPageLocators loginLocators;

	 public LoginPage(DriverManager driverManager) {
	        this.driver = driverManager.getDriver();
	        this.seleniumutils = new SeleniumUtils(driverManager); // Pass the same instance
	        this.loginLocators = new LoginPageLocators();
	        PageFactory.initElements(driver, loginLocators);
	    }

	public boolean ValidateLogingpage(String title) {

		return seleniumutils.validateTitle(title);
	}

	public void enterUsername(String userEmailid) {
		
		seleniumutils.waitForElementToBeVisible(loginLocators.getEmail());
		
		seleniumutils.enterText(loginLocators.getEmail(), userEmailid);
	}

	public void enterPassword(String userPassword) {

		seleniumutils.enterText(loginLocators.getPassword(), userPassword);
	}

	public void clickLogiButton() {

		seleniumutils.click(loginLocators.getLoginButton());
	}

}
