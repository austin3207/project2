package com.revature.project2.stepdefinitions;

import com.revature.project2.components.RegisterComponent;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register extends StepDefinition {
	
	RegisterComponent registerComponent = new RegisterComponent();

//	Scenario: Registration Navigation
	@Given("^I am on the login page$")
	public void i_am_on_the_login_page() {
		goToEndpoint("login");
	}
	
	@And("^The option is given to register$")
	public void the_option_is_given_to_register() {
		checkIfLinkExists("register");
	}
	
	@When("^I click the register link$")
	public void i_click_the_register_link() {
		clickItem("register");
	}
	
	@Then("^A registration form appears$")
	public boolean a_registration_form_appears() {
		boolean result = checkNewWindow(registerComponent.getTitleElementID());
		getDriver().close();
		return result;
	}
	
	
	
//	Scenario: Successful Registration
	@Given("^I am at the registration form$")
	public void i_am_at_the_registration_form() {
		goToEndpoint("login");
		clickItem("register");
	}
	
	@When("^I enter first name as Zachary$")
	public void i_enter_first_name() {
		sendKeys(registerComponent.getFirstNameElementID(), "Zachary");
	}
	
	@And("^I enter last name as Miller$")
	public void i_enter_last_name() {
		sendKeys(registerComponent.getLastNameElementID(), "Miller");
	}
	
	@And("^I enter email as zachary.miller@revature.net$")
	public void i_enter_email() {
		sendKeys(registerComponent.getEmailElementID(), "zachary.miller@revature.net");
	}
	
	@And("^I enter password as P@ssw0rd$")
	public void i_enter_password() {
		sendKeys(registerComponent.getPasswordElementID(), "P@ssw0rd");
	}
	
	@And("^I click submit$")
	public void i_click_submit() {
		clickItem(registerComponent.getSubmitElementID());
	}
	
	@Then("^My profile should be created$")
	public void my_profile_should_be_created() {
		//Still needed
	}
	
	@And("^I should see my account profile$")
	public void i_should_see_my_account_profile() {
		String url = "http://localhost:8080/api/accounts/"; //URL for accounts
		String  id = String.valueOf(0); //Retrieve id from newly created account
		String accountURL = url + id;
		getDriver().getCurrentUrl().equals(accountURL);
		getDriver().close();
	}
	
	
	
//	Scenario: Registration Cancellation
	@Given("^I am at the registration form2$")
	public void i_am_at_the_registration_form2() {
		goToEndpoint("login");
		clickItem("register");
	}
	
	@When("^I click cancel$")
	public void i_click_cancel() {
		clickItem(registerComponent.getCancelElementID());
	}
	
	@Then("^The Form should close$")
	public void the_form_should_close() {
		//Will need to better understand what occurs when the form opens to know how to identify that it closes
		getDriver().close();
	}
}
