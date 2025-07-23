package com.demo.loacators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {

	@FindBy(xpath = "//*[@id='email']")
	private WebElement email;
	@FindBy(xpath = "//*[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//*[@id='login-form']/div[3]/input")
	private WebElement loginButton;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

}
