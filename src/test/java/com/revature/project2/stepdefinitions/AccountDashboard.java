package com.revature.project2.stepdefinitions;

import org.openqa.selenium.By;

import com.revature.project2.components.LoginComponent;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountDashboard extends StepDefinition {
	
	LoginComponent loginComponent = new LoginComponent();
	
	//Opens chrome and navigates to dashboard
	@Given("^I am on my profile page$")
	public void i_am_on_my_profile_page() {
		goToEndpoint("accounts/1");
	}

	//Verifies that the page I am sent to is the profile page
	@Then("^I should see my account dashboard$") 
	public void i_should_see_my_account_dashboard() {
		String content = getDriver().findElement(By.tagName("pre")).getText().toString();
		getDriver().close();
		System.out.println(content);
	}

	

}
