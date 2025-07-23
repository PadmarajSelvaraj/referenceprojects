package com.demo.loacators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsuranceHomePageLocators {

	@FindBy(xpath = "//*[@class='content' and contains(text(), 'Signed ')]")
	private WebElement signinintxt;

	@FindBy(xpath = "//*[@class='content']/h4")
	private WebElement useremailid;

	@FindBy(xpath = "//*[@id='menu']/li")
	private List<WebElement> insuranceMenuItems;

	
	
	public WebElement getSiginintxt() {
		return signinintxt;
	}
	
	public WebElement getUseremailid() {
		return useremailid;
	}

	public List<WebElement> getInsuranceMenuItems() {
		return insuranceMenuItems;
	}

	

}
