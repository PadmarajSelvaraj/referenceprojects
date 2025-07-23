package com.demo.loacators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RequestQutoationPageLocators {

	@FindBy(xpath = "//*[@id='new_quotation']/div[8]/input[1]")
	private WebElement premiumButton;

	@FindBy(xpath = "//*[@id='new_quotation']/div[2]/label")
	private WebElement policyexcesstxt;
	
	@FindBy(xpath = "//*[@id='new_quotation']/div[2]/text()[2]")
	private WebElement policyexcesstxtvalue;

	@FindBy(xpath = "//*[@id='new_quotation']/div[3]/label")
	private WebElement breakdowncovertxt;

	@FindBy(xpath = "//select[@id='quotation_breakdowncover']")
	private WebElement breakdownCover;

	@FindBy(xpath = "//*[@id='new_quotation']/div[4]/input[@value='Yes']")
	private WebElement yesButton;

	@FindBy(xpath = "//*[@id='new_quotation']/div[4]/input[@value='No']")
	private WebElement noButton;

	@FindBy(xpath = "//*[@id='tabs-5']")
	private WebElement excesspaidtxt;

	@FindBy(xpath = "//input[@id='quotation_incidents']")
	private WebElement quotationIncident;

	@FindBy(xpath = "//input[@id='quotation_vehicle_attributes_registration']")
	private WebElement quotatioRegistration;
	
	@FindBy(xpath = "//input[@id='quotation_vehicle_attributes_mileage']")
	private WebElement quotatioMileage;
	
	@FindBy(xpath = "//input[@id='quotation_vehicle_attributes_value']")
	private WebElement quotatioEstimatedValue;
	
	@FindBy(xpath = "//select[@id='quotation_vehicle_attributes_parkinglocation']")
	private WebElement quotationParkingLocation;
	
	@FindBy(xpath = "//select[@id='quotation_vehicle_attributes_policystart_1i']")
	private WebElement policyYear;
	
	@FindBy(xpath = "//select[@id='quotation_vehicle_attributes_policystart_2i']")
	private WebElement policyMonth;
	
	@FindBy(xpath = "//select[@id='quotation_vehicle_attributes_policystart_3i']")
	private WebElement policyDate;
	
	@FindBy(xpath = "//input[@id='resetquote']")
	private WebElement resetForm;
	
	@FindBy(xpath = "//*[@id='new_quotation']/div[8]/input[3]")
	private WebElement saveButton;
	
	@FindBy(xpath = "//*[@id='calculatedpremium']")
	private WebElement premium;
	
	@FindBy(xpath = "//*[@id='tabs-2']/h2")
	private WebElement requestQuotationText;
	
	@FindBy(xpath = "//body")
	private WebElement identification;
	
	@FindBy(xpath = "//input[@value ='Save Quotation']")
	private WebElement saveQuotation;
	
	@FindBy(xpath = "//*[@id='resetquote']")
	private WebElement resetFormButton;

	public WebElement getPolicyexcesstxt() {
		return policyexcesstxt;
	}
	
	public WebElement getsaveQuotation() {
		return saveQuotation;
	}
	
	public WebElement getidentification() {
		return identification;
	}

	public WebElement getresetFormButton() {
		return resetFormButton;
	}


	public WebElement getPolicyexcesstxtvalue() {
		return policyexcesstxtvalue;
	}


	public WebElement getBreakdowncovertxt() {
		return breakdowncovertxt;
	}


	public WebElement getBreakdownCover() {
		return breakdownCover;
	}


	public WebElement getYesButton() {
		return yesButton;
	}


	public WebElement getNoButton() {
		return noButton;
	}


	public WebElement getExcesspaidtxt() {
		return excesspaidtxt;
	}


	public WebElement getQuotationIncident() {
		return quotationIncident;
	}


	public WebElement getQuotatioRegistration() {
		return quotatioRegistration;
	}


	public WebElement getQuotatioMileage() {
		return quotatioMileage;
	}


	public WebElement getQuotatioEstimatedValue() {
		return quotatioEstimatedValue;
	}


	public WebElement getQuotationParkingLocation() {
		return quotationParkingLocation;
	}


	public WebElement getPolicyYear() {
		return policyYear;
	}


	public WebElement getPolicyMonth() {
		return policyMonth;
	}


	public WebElement getPolicyDate() {
		return policyDate;
	}


	public WebElement getResetForm() {
		return resetForm;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getPremiumButton() {
		return premiumButton;
	}
	
	public WebElement getPremium() {
		return premium;
	}
	
	public WebElement getrequestQuotationText() {
		return requestQuotationText;
	}


	
}
