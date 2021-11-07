package com.revature.project2.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDefinitions {
	
	static WebDriver driver = getWebDriver(); //Calls getWebDriver() and stores result in 'driver'
	
	//Sets system property specifying the driver and it's location
		public static WebDriver getWebDriver() {
			System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver(); //Create instance
			return driver; 
		}

//	Scenario: Registration Navigation
	@Given("^I am on the login page$")
	public void i_am_on_the_login_page() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://localhost:8080/api/login");
	}
	
	@And("^The option is given to register$")
	public Boolean the_option_is_given_to_register() {
		boolean exists = driver.findElement(By.linkText("Register")).isDisplayed();
		return exists;
	}
	
	@When("^I click the register link$")
	public void i_click_the_register_link() {
		driver.findElement(By.linkText("Register")).click();
	}
	
	@Then("^A registration form appears$")
	public boolean a_registration_form_appears() {
		if(driver.getWindowHandles().size() > 1) {
//			String currentHandle = driver.getWindowHandles().iterator().next().toString();
			String otherHandle = driver.getWindowHandles().iterator().next().toString();
			if(!driver.getTitle().equals("Registration Form"))  {
				driver.switchTo().window(otherHandle);
				if(!driver.getTitle().equals("Registration Form")) {
					System.out.println("No 'Registration Form' found");
				}
				
				else {
					System.out.println("'Registration Form' opened.");
					return true;
				}
			}
			
			else {
				System.out.println("'Registration Form' opened.");
				return true;
			}
		}
		
		else {
			if(!driver.getTitle().equals("Registration Form")) {
				System.out.println("No 'Registration Form' found");
			}
			
			else {
				System.out.println("'Registration Form' opened.");
				return true;
			}
		}
		return false;
	}
	
	
	
//	Scenario: Successful Registration
	@Given("^I am at the registration form$")
	public void i_am_at_the_registration_form() {
		driver.navigate().to("http://localhost:8080/api/login");
		driver.findElement(By.linkText("Register")).click();
		boolean atForm = a_registration_form_appears();
		if(atForm) {
			System.out.println("Confirmed at 'Registration Form'");
		}
		
		else {
			System.out.println("Failed to get 'Registration Form'");
		}
	}
	
	@When("^I enter first name as Zachary$")
	public void i_enter_first_name() {
		driver.findElement(By.id("firstName")).sendKeys("Zachary");
	}
	
	@And("^I enter last name as Miller$")
	public void i_enter_last_name() {
		driver.findElement(By.id("lastName")).sendKeys("Miller");
	}
	
	@And("^I enter email as zachary.miller@revature.net$")
	public void i_enter_email() {
		driver.findElement(By.id("email")).sendKeys("zachary.miller@revature.net");
	}
	
	@And("^I enter password as P@ssw0rd$")
	public void i_enter_password() {
		driver.findElement(By.id("password")).sendKeys("P@ssw0rd");
	}
	
	@And("^I click submit$")
	public void i_click_submit() {
		driver.findElement(By.id("submit")).click();
	}
	
	@Then("^My profile should be created$")
	public void my_profile_should_be_created() {
		
	}
	
	@And("^I should see my account profile$")
	public Boolean i_should_see_my_account_profile() {
		String url = "http://localhost:8080/api/accounts/"; //URL for accounts
		String  id = String.valueOf(0); //Retrieve id from newly created account
		String accountURL = url + id;
		boolean onAccountPage = driver.getCurrentUrl().equals(accountURL); 
		return onAccountPage;
	}
	
	
	
//	Scenario: Registration Cancellation
	@Given("^I am at the registration form2$")
	public void i_am_at_the_registration_form2() {
		driver.navigate().to("http://localhost:8080/api/login");
		driver.findElement(By.linkText("Register")).click();
		boolean atForm = a_registration_form_appears();
		if(atForm) {
			System.out.println("Confirmed at 'Registration Form'");
		}
		
		else {
			System.out.println("Failed to get 'Registration Form'");
		}
	}
	
	@When("^I click cancel$")
	public void i_click_cancel() {
		driver.findElement(By.id("cancel")).click();
	}
	
	@Then("^The Form should close$")
	public void the_form_should_close() {
		//Will need to better understand what occurs when the form opens to know how to identify that it closes
	}
}
