package com.revature.project2.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSuccess {
	
	static WebDriver driver = getWebDriver(); //Calls getWebDriver() and stores result in 'driver'
	
	//Sets system property specifying the driver and it's location
	public static WebDriver getWebDriver() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //Create instance
		return driver; 
	}
	
	//Opens chrome and navigates to login page
	@Given("^I am on /api/login$")
	public void i_am_on_api_login() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://localhost:8080/api/login");
	}
	
	//Enters username
	@When("^username is zachary.miller@revature.net$")
	public void username_is_correct() {
		driver.findElement(By.id("<ElementID>")).sendKeys("zachary.miller@revature.net");
	}
	
	//Enters password
	@And("^password is P@ssw0rd$")
	public void password_is_correct() {
		driver.findElement(By.id("<ElementID>")).sendKeys("P@ssw0rd");
	}
	
	//Clicks submit
	@And("^Submit button is pressed$") 
	public void submit_button_is_pressed() {
		driver.findElement(By.id("<ElementID>")).click();
	}
	
	//Verifies that the page I am sent to is the profile page
	@Then("^I should be presented with my profile page$") 
	public void i_should_be_presented_with_my_profile_page() {
		assertTrue(driver.getTitle().equals("<Title of page for user Profile>"));
		driver.close();
	}

	
}
