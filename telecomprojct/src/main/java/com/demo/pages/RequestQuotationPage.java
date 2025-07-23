package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.demo.loacators.HomePageLocators;
import com.demo.loacators.RequestQutoationPageLocators;
import com.demo.utils.DriverManager;
import com.demo.utils.SeleniumUtils;
import com.demo.utils.SharedContext;

public class RequestQuotationPage {
	private WebDriver driver;
	private SeleniumUtils seleniumutils;
	private RequestQutoationPageLocators requestPageLocator;
	
	
	public RequestQuotationPage(DriverManager driverManager) {
		this.driver = driverManager.getDriver();
		this.seleniumutils = new SeleniumUtils(driverManager);
		requestPageLocator = new RequestQutoationPageLocators();
		PageFactory.initElements(driver, requestPageLocator);
		

	}

	public void scrolldown() {

		// Y-Position: int yPosition = element.getLocation().getY(); — This gets the
		// vertical position of the element from the top of the page in pixels.

		// X-Position: You can also get the horizontal position using
		// element.getLocation().getX();.
		int yPosition = requestPageLocator.getPremiumButton().getLocation().getY();

		int elehieght = requestPageLocator.getPremiumButton().getSize().height;

		seleniumutils.scrollUPDown(yPosition - elehieght);

	}

	public boolean validateRequestPage() {

		String quoteText = "Request a quotation";
		return seleniumutils.validateText(requestPageLocator.getrequestQuotationText(), quoteText);
	}

	public void selectBreakdowncover(String breakdowntxt) {

		seleniumutils.selectDropdownByVisibleText(requestPageLocator.getBreakdownCover(), breakdowntxt);
	}

	public void selectlocation(String location) {

		seleniumutils.selectDropdownByVisibleText(requestPageLocator.getQuotationParkingLocation(), location);
	}

	public void selectYear(String year) {

		seleniumutils.selectDropdownByVisibleText(requestPageLocator.getPolicyYear(), year);
	}

	public void selectMonth(String month) {

		seleniumutils.selectDropdownByVisibleText(requestPageLocator.getPolicyMonth(), month);
	}

	public void selectDate(String date) {

		seleniumutils.selectDropdownByVisibleText(requestPageLocator.getPolicyDate(), date);
	}

	public void clickCalulatePremiumbutoon() {

		seleniumutils.click(requestPageLocator.getPremiumButton());
	}

	public boolean checkPremiumHidden() {

		return seleniumutils.isElementDisplayed(requestPageLocator.getPremium());

	}

	public String getPremium() {

		// if(checkPremiumHidden()) {

		return seleniumutils.getText(requestPageLocator.getPremium());

		// }
		// return "";
	}

	public void clickWindscreenrepairRadiobutton(String selection) {
		if (selection.equals("Yes"))
			seleniumutils.selectRadioButton(requestPageLocator.getYesButton());
		else
			seleniumutils.selectRadioButton(requestPageLocator.getNoButton());
	}

	public void enterIncident(String text) {

		seleniumutils.enterText(requestPageLocator.getQuotationIncident(), text);
	}

	public String getIncidentText() {

		return seleniumutils.getText(requestPageLocator.getQuotationIncident());
	}

	public void enterRegistration(String text) {

		seleniumutils.enterText(requestPageLocator.getQuotatioRegistration(), text);
	}

	public void enterMilage(String text) {

		seleniumutils.enterText(requestPageLocator.getQuotatioMileage(), text);
	}

	public void enterValue(String text) {

		seleniumutils.enterText(requestPageLocator.getQuotatioEstimatedValue(), text);
	}

	public String getidentificationtext() {

		return seleniumutils.getText(requestPageLocator.getidentification());
	}
	
	public String getIncidenttext() {

		return seleniumutils.getText(requestPageLocator.getQuotationIncident());
	}	

	public void clickSaveQuotation() {

		seleniumutils.click(requestPageLocator.getSaveButton());
	}

	public void clickResetForm() {

		seleniumutils.click(requestPageLocator.getresetFormButton());

	}
}
