package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.demo.loacators.ReriveQuotationPageLocators;
import com.demo.utils.DriverManager;
import com.demo.utils.SeleniumUtils;

public class ReriveQuotationPage {

	private WebDriver driver;
	private SeleniumUtils seleniumutils;
	private ReriveQuotationPageLocators reriveQuotationPageLocator;

	public ReriveQuotationPage(DriverManager driverManager) {
		this.driver = driverManager.getDriver();

		seleniumutils = new SeleniumUtils(driverManager);
		reriveQuotationPageLocator = new ReriveQuotationPageLocators();
		PageFactory.initElements(driver, reriveQuotationPageLocator);

	}

	public void enterRetriveidentification(String idText) {

		seleniumutils.enterText(reriveQuotationPageLocator.getRetriveidentification(), idText);
	}

	public void clickRetriveibutton() {

		seleniumutils.click(reriveQuotationPageLocator.getRetriveidentificationButton());
	}
	
	public void getRetriveTableData() {

		seleniumutils.getTableData(reriveQuotationPageLocator.getRetriveTable());
		
	}
	

}
