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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class PolicyCreationTest {
	
	//private WebDriver driver;
	private HomePage home;
	private LoginPage login;
	private InsuranceHomePage inshomepage;
	private String username;
	private DriverManager drivermanger;
	
	public PolicyCreationTest() {
		
		drivermanger = new DriverManager();
		//driver = drivermanger.getDriver();
		home = new HomePage(drivermanger);
		login = new LoginPage(drivermanger);
		inshomepage = new InsuranceHomePage(drivermanger);
		
	}

	
	@Given("the user selects {string} on the Home Page")
	public void the_user_selects_on_the_home_page(String projectname) {
	   
		home.selectProjectbyName(projectname);
	}
	
	@Then("the user navigates to the {string} Login Page")
	public void the_user_navigates_to_the_login_page(String title) {
	  
		//Assertions.assertTrue(login.ValidateLogingpage(title));
	   
	}
	@When("the user enters {string} and {string}")
	public void the_user_enters_and(String username, String password) {
		this.username = username;
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLogiButton();
	   
	}
	@Then("a message is displayed {string}")
	public  void a_message_is_displayed(String expectedtxt) {
	    
		
		  String signintxt = inshomepage.HomePageSiginintxt(); 
		
		 Pattern pattern = Pattern.compile(".*\\s+(\\w+@\\w+\\.com)");
		 Matcher  match =  pattern.matcher(signintxt);
		  
		 String actualtxt="";
		 if(match.find()) {
			 
			 actualtxt = actualtxt+ match.group();
		 }
		 
		  Assertions.assertEquals(expectedtxt+"\n"+username, actualtxt);
		 
		  
		  
		  
		  
}
	
	

	
}
