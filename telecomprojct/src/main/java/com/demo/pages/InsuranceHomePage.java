package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.demo.loacators.InsuranceHomePageLocators;
import com.demo.utils.DriverManager;
import com.demo.utils.SeleniumUtils;

public class InsuranceHomePage {
	private WebDriver driver;
	private SeleniumUtils seleniumutils;
	private InsuranceHomePageLocators inshomepageLocator;

	public InsuranceHomePage(DriverManager driverManager) {
		this.driver = driverManager.getDriver();
		this.seleniumutils = new SeleniumUtils(driverManager);
		inshomepageLocator = new InsuranceHomePageLocators();
		PageFactory.initElements(driver, inshomepageLocator);

	}

	public String HomePageSiginintxt() {

		return seleniumutils.getText(inshomepageLocator.getSiginintxt());

	}

	public String HomePageUseremailtxt() {

		return seleniumutils.getText(inshomepageLocator.getUseremailid());
		
	

	}

	public void selectInsuranceMenubyName(String insMenu) {

		seleniumutils.clickOnListByText(inshomepageLocator.getInsuranceMenuItems(), insMenu);

	}

}
