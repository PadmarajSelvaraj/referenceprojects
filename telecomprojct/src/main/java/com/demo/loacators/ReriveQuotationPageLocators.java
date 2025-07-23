package com.demo.loacators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReriveQuotationPageLocators {

	@FindBy(xpath = "//*[@id='tabs-3']/form/input[1]")
	private WebElement retriveidentification;
	
	@FindBy(xpath = "//*[@id='getquote']")
	private WebElement retriveidentificationButton;
	
	@FindBy(xpath = "/html/body/table")
	private WebElement retriveTable;
	
	public WebElement getRetriveidentification() {
		return retriveidentification;
	}

	public WebElement getRetriveidentificationButton() {
		return retriveidentificationButton;
	}

	public WebElement getRetriveTable() {
		return retriveTable;
	}


	
}
