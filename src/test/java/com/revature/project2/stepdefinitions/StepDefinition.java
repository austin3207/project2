package com.revature.project2.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.revature.project2.util.WebDriverChrome;

public class StepDefinition {
	private final WebDriver driver = WebDriverChrome.getWebDriver("chrome");
	private final String baseURL = "http://localhost:8080/api/";
	private String endpoint;
	private String elementID;

	public String getElementID() {
		return elementID;
	}

	public void setElementID(String elementID) {
		this.elementID = elementID;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void goToEndpoint(String desiredEndpoint) {
		setEndpoint(desiredEndpoint);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(getURL());
	}

	public String getURL() {
		return getBaseURL() + getEndpoint();
	}

	public StepDefinition() {
		super();
	}

}
