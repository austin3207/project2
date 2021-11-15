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
	
	@When("^I click the register link$")
	public void i_click_the_register_link() {
		clickItem(loginComponent.getRegisterIdentifier(), "linkText");
	}
	
	@Then("^A registration form appears$")
	public void a_registration_form_appears() {
		if(checkCurrentPage().equals(getBaseURL()+"/register")) {
			System.out.println("Registration Form Presented");
		}
		getDriver().close();
	}
	
	
	
//	Scenario: Successful Registration
	@Given("^I am at the registration form$")
	public void i_am_at_the_registration_form() {
		goToSite();
		clickItem(loginComponent.getRegisterIdentifier(), "linkText");
	}
	
	@When("^I enter first name as Zachary$")
	public void i_enter_first_name() {
		sendKeys(registerComponent.getFirstNameIdentifier(), "Zachary", "id");
	}
	
	@And("^I enter last name as Miller$")
	public void i_enter_last_name() {
		sendKeys(registerComponent.getLastNameIdentifier(), "Miller", "id");
	}
	
	@And("^I enter email as zachary.miller@revature.net$")
	public void i_enter_email() {
		sendKeys(registerComponent.getEmailIdentifier(), "zachary.miller@revature.net", "id");
	}
	
	@And("^I enter password as P@ssw0rd$")
	public void i_enter_password() {
		sendKeys(registerComponent.getPasswordIdentifier(), "P@ssw0rd", "id");
	}
	
	@And("^I confirm password$")
	public void i_confirm_password() {
		sendKeys(registerComponent.getConfirmPasswordIdentifier(), "P@ssw0rd", "id");
	}
	
	@And("^I click submit$")
	public void i_click_submit() {
		clickItem(registerComponent.getSubmitIdentifier(), "css selector");
	}
	
	@Then("^My profile should be created$")
	public void my_profile_should_be_created() {
		//Still needed
	}
	
	@And("^I should see my account profile$")
	public void i_should_see_my_account_profile() {
		//Perform validation that this is equal to where I am located
		getDriver().close();
	}
}
