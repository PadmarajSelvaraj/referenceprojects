package com.demo.stepdefinition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import com.demo.pages.HomePage;
import com.demo.pages.InsuranceHomePage;
import com.demo.pages.LoginPage;
import com.demo.pages.RequestQuotationPage;
import com.demo.utils.DriverManager;
import com.demo.utils.SharedContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QuotationTest {

	private WebDriver driver;
	private RequestQuotationPage requestPage;
	private InsuranceHomePage inshomepage;
	private DriverManager drivermanger;
	public QuotationTest() {

		drivermanger = new DriverManager();
		driver = drivermanger.getDriver();
		requestPage = new RequestQuotationPage(drivermanger);
		inshomepage = new InsuranceHomePage(drivermanger);		
	}

	@Given("user on the registration quotation page")
	public void user_on_the_registration_quotation_page() {
		inshomepage.selectInsuranceMenubyName("Request Quotation");
		Assertions.assertTrue(requestPage.validateRequestPage());

	}

	@When("user selects {string}")
	public void user_selects(String string) {
		requestPage.scrolldown();
		requestPage.selectBreakdowncover(string);
	}

	@When("user clicks the radio button {string}")
	public void user_clicks_the_radio_button(String selection) {

		requestPage.clickWindscreenrepairRadiobutton(selection);
	}

	@When("user enters {string},{string},{string},{string}")
	public void user_enters(String incidents, String registration, String milage, String value) {

		requestPage.enterIncident(incidents);
		requestPage.enterRegistration(registration);
		requestPage.enterMilage(milage);
		requestPage.enterValue(value);
	}

	@When("user selects qutoation details {string},{string},{string},{string}")
	public void user_selects_qutoation_details(String location, String year, String month, String date) {

		requestPage.selectlocation(location);
		requestPage.selectYear(year);
		requestPage.selectMonth(month);
		requestPage.selectDate(date);
	}

	@When("user selects calculate prememium")
	public void user_selects_calculate_prememium() {

		requestPage.clickCalulatePremiumbutoon();
	}

	@Then("the premimum should calculated sucessfully")
	public void the_premimum_should_calculated_sucessfully() {

		String premiumtxt = requestPage.getPremium();

		Pattern pattern = Pattern.compile("\\b\\d.*");

		Matcher match = pattern.matcher(premiumtxt);
		String premium = "";

		while (match.find()) {
			System.out.println("The premium is " + match.group());
		premium = match.group();
		}
		
		requestPage.clickSaveQuotation();
		
		String identification = requestPage.getidentificationtext();
		
		

		//Pattern identificationPattern = Pattern.compile(".*\\sYour identification number is :\\s*\\d+", Pattern.DOTALL);
		Pattern identificationPattern = Pattern.compile("\\d+", Pattern.DOTALL);

		Matcher idmatch = identificationPattern.matcher(identification);
		
		String identiificationNumber = "";

		if (idmatch.find()) {
			System.out.println("The identiificationNumber is " + idmatch.group());
			identiificationNumber = idmatch.group();
		}
		
		SharedContext.setContext("identificationText", identiificationNumber);
		
	}
	
	@When("user selects Reset form")
	public void user_selects_reset_form() {
	  
		requestPage.clickResetForm();
	}

	@Then("text should be cleared")
	public void text_should_be_cleared() {
	   
		boolean abc = requestPage.getIncidenttext().isEmpty();
		Assertions.assertTrue(requestPage.getIncidenttext().isEmpty());
		
	}

}
