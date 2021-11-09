package com.revature.project2.stepdefinitions;

import com.revature.project2.components.AccountComponent;
import com.revature.project2.components.LoginComponent;
import com.revature.project2.components.RegisterComponent;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register extends StepDefinition {
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	LoginComponent loginComponent = new LoginComponent();
	RegisterComponent registerComponent = new RegisterComponent();
	AccountComponent accountComponent = new AccountComponent();

//	Scenario: Registration Navigation
	@Given("^I am on the login page$")
	public void i_am_on_the_login_page() {
		goToSite();
	}
	
	@And("^The option is given to register$")
	public void the_option_is_given_to_register() {
		checkIfLinkExists(loginComponent.getRegisterElementID());
	}
	
	@When("^I click the register link$")
	public void i_click_the_register_link() {
		clickItem(loginComponent.getRegisterElementID());
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
		goToSite();
		clickItem(loginComponent.getRegisterElementID());
	}
	
	@When("^I enter first name as Zachary$")
	public void i_enter_first_name() {
		sendKeys(registerComponent.getFirstNameElementID(), getFirstName());
	}
	
	@And("^I enter last name as Miller$")
	public void i_enter_last_name() {
		sendKeys(registerComponent.getLastNameElementID(), getLastName());
	}
	
	@And("^I enter email as zachary.miller@revature.net$")
	public void i_enter_email() {
		sendKeys(registerComponent.getEmailElementID(), getEmail());
	}
	
	@And("^I enter password as P@ssw0rd$")
	public void i_enter_password() {
		sendKeys(registerComponent.getPasswordElementID(), getPassword());
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
		//Perform validation that this is equal to where I am located
		accountComponent.getTitleElementID();
	}
	
	
	
//	Scenario: Registration Cancellation
	@Given("^I am at the registration form2$")
	public void i_am_at_the_registration_form2() {
		goToSite();
		clickItem(loginComponent.getRegisterElementID());
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
