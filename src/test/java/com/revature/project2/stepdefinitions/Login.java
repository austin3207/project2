package com.revature.project2.stepdefinitions;

import org.openqa.selenium.By;

import com.revature.project2.components.LoginComponent;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends StepDefinition {
	
	LoginComponent loginComponent = new LoginComponent();
	
	//Opens chrome and navigates to login page
	@Given("^I am on /api/login$")
	public void i_am_on_api_login() {
		goToEndpoint("login");
	}

	//Enters username
	@When("^username is zachary.miller@revature.net$")
	public void username_is_correct() {
		getDriver()
		.findElement(By.id(loginComponent.getUsernameElementID()))
		.sendKeys("zachary.miller@revature.net");
	}

	//Enters password
	@And("^password is P@ssw0rd$")
	public void password_is_correct() {
		getDriver()
		.findElement(By.id(loginComponent.getPasswordElementID()))
		.sendKeys("P@ssw0rd");
	}

	//Clicks submit
	@And("^Submit button is pressed$") 
	public void submit_button_is_pressed() {
		getDriver()
		.findElement(By.id(loginComponent.getSubmitElementID()))
		.click();
	}

	//Verifies that the page I am sent to is the profile page
	@Then("^I should be presented with my profile page$") 
	public void i_should_be_presented_with_my_profile_page() {
		getDriver()
		.getTitle().equals(loginComponent.getTitleElementID());
		getDriver().close();
	}

	

}