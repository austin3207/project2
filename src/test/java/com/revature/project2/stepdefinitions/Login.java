package com.revature.project2.stepdefinitions;

import com.revature.project2.components.AccountComponent;
import com.revature.project2.components.LoginComponent;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends StepDefinition {
	
	LoginComponent loginComponent = new LoginComponent();
	AccountComponent accountComponent = new AccountComponent();
	
	//Opens chrome and navigates to login page
	@Given("^I am on /api/login$")
	public void i_am_on_api_login() {
		goToEndpoint("login");
	}

	//Enters username
	@When("^username is zachary.miller@revature.net$")
	public void username_is_correct() {
		sendKeys(loginComponent.getUsernameElementID(), "Zachary.miller@revature.net");
	}

	//Enters password
	@And("^password is P@ssw0rd$")
	public void password_is_correct() {
		sendKeys(loginComponent.getPasswordElementID(), "P@ssw0rd");
	}

	//Clicks submit
	@And("^Submit button is pressed$") 
	public void submit_button_is_pressed() {
		clickItem(loginComponent.getSubmitElementID());
	}

	//Verifies that the page I am sent to is the profile page
	@Then("^I should be presented with my profile page$") 
	public void i_should_be_presented_with_my_profile_page() {
		String url = checkCurrentPage();
		int accountIdIndex = url.lastIndexOf('/', 0);
		String accountId = url.substring(accountIdIndex);
		System.out.println(accountId);
//		if(url.equals(accountComponent.getURL())) {
//			System.out.println("Profile page loaded");
//		}
		getDriver().close();
	}
}