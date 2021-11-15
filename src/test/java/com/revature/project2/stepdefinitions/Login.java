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
	@Given("^I am on landing page$")
	public void i_am_on_landing_page() {
		goToSite();
	}

	//Enters username
	@When("^username is zachary.miller@revature.net$")
	public void username_is_correct() {
		sendKeys(loginComponent.getUsernameIdentifier(), "zachary.miller@revature.net", "id");
	}

	//Enters password
	@And("^password is P@ssw0rd$")
	public void password_is_correct() {
		clickItem(loginComponent.getPasswordIdentifier(), "css selector");
		System.out.println(loginComponent.getPasswordIdentifier());
		sendKeys(loginComponent.getPasswordIdentifier(), "P@ssw0rd", "css selector");
	}

	//Clicks submit
	@And("^Submit button is pressed$") 
	public void submit_button_is_pressed() {
		clickItem(loginComponent.getSubmitIdentifier(), "css selector");
	}

	//Verifies that the page I am sent to is the profile page
	@Then("^I should be presented with my profile page$") 
	public void i_should_be_presented_with_my_profile_page() {
		String url = checkCurrentPage();
		if(url.equals(getBaseURL()+"/recipes")) {
			System.out.println("Recipes page loaded");
		}
		getDriver().close();
	}
}