package com.demo.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginTest {

	@Given("the following users exist:")
	public void the_following_users_exist(DataTable dataTable) {

		/*
		 * List<List<String>> data = dataTable.asLists();
		 * 
		 * for (List<String> list : data) {
		 * 
		 * System.out.println(list.get(0)); }
		 */

		/*
		 * List<Map<String, String>> test = dataTable.asMaps();
		 * 
		 * for (Map<String, String> map : test) {
		 * 
		 * System.out.println(map.get("username")); }
		 */

		
	}

	@When("I log in as {string} with password {string}")
	public void i_log_in_as_with_password(String string, String string2) {
       
	 System.out.println("This should get get failed");
	 Assertions.assertTrue(false);
	}

	@Then("I should see a welcome message for {string}")
	public void i_should_see_a_welcome_message_for(String string) {

	}

	@Then("I should see an error message for {string}")
	public void i_should_see_an_error_message_for(String string) {

	}

}
