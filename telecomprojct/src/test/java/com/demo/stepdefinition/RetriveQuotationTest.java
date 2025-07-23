package com.demo.stepdefinition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import com.demo.pages.HomePage;
import com.demo.pages.InsuranceHomePage;
import com.demo.pages.LoginPage;
import com.demo.pages.ReriveQuotationPage;
import com.demo.utils.DriverManager;
import com.demo.utils.SharedContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RetriveQuotationTest {

	private WebDriver driver;
	private ReriveQuotationPage retrievePage;
	private InsuranceHomePage inshomepage;
	private DriverManager drivermanger;
	
	public RetriveQuotationTest() {

		drivermanger = new DriverManager();
		driver = drivermanger.getDriver();
		retrievePage = new ReriveQuotationPage(drivermanger);
		inshomepage = new InsuranceHomePage(drivermanger);	
	}

	@Given("user on the retrieve quotation page")
	public void user_on_the_retrieve_quotation_page() {
		inshomepage.selectInsuranceMenubyName("Retrieve Quotation");
	}

	@When("user enters identification")
	public void user_enters_identification() {
		retrievePage.enterRetriveidentification(SharedContext.getContext("identificationText"));
	}

	@When("click on retrive buton")
	public void click_on_retrive_buton() {
		retrievePage.clickRetriveibutton();
	}

	@Then("Quotation details should get retrieved sucessfully")
	public void quotation_details_should_get_retrieved_sucessfully() {
		
		retrievePage.getRetriveTableData();
	}
	

}
