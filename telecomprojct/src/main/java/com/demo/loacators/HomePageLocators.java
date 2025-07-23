package com.demo.loacators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

	@FindBy(xpath = "//div[@id='navbar-brand-centered']/ul/li")
	private List<WebElement> items;

	public List<WebElement> getItems() {
		return items;
	}

}
