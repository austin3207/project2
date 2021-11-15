package com.revature.project2.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.project2.util.WebDriverChrome;

public class StepDefinition {
	private final WebDriver driver = WebDriverChrome.getWebDriver("chrome");
	private final String baseURL = "http://localhost:5500";
	private String identifier;
	private String linkText;

	public String getLinkText() {
		return linkText;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public String identifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getBaseURL() {
		return baseURL;
	}

	public void goToSite() {
		driver.navigate().to(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public boolean checkIfLinkExists(String linkText) {
		boolean exists = driver.findElement(By.linkText(linkText)).isDisplayed();
		return exists;
	}

	public void sendKeys(String identifier, String keys, String elementType) {
		switch (elementType) {

		case ("css selector"):
			driver.findElement(By.cssSelector(identifier)).sendKeys(keys);
			break;

		case ("id"):
			driver.findElement(By.id(identifier)).sendKeys(keys);
			break;
		}
	}

	public void clickItem(String identifier, String elementType) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		switch (elementType) {

		case ("css selector"):
			WebElement webElementByCssSelector = driver.findElement(By.cssSelector(identifier));
			if (webElementByCssSelector.getTagName().equals("button")) {
				webElementByCssSelector.submit();
			} else {
				webElementByCssSelector.click();
			}
			
			break;

		case ("id"):
			WebElement webElementById = driver.findElement(By.id(identifier));
			if (webElementById.getTagName().equals("button")) {
				webElementById.submit();
			} else {
				webElementById.click();
			}
			break;
			
		case ("linkText"): 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.linkText(identifier)).click();
			break;
		}
		
	}

	public String checkCurrentPage() {
		return driver.getCurrentUrl();
	}

	public boolean checkNewWindow(String title) {
		if (driver.getWindowHandles().size() > 1) {
//			String currentHandle = driver.getWindowHandles().iterator().next().toString();
			String otherHandle = driver.getWindowHandles().iterator().next().toString();
			if (!driver.getTitle().equals(title)) {
				driver.switchTo().window(otherHandle);
				if (!driver.getTitle().equals(title)) {
					System.out.println("No " + title + " found");
				}

				else {
					System.out.println(title + " opened.");
					return true;
				}
			}

			else {
				System.out.println(title + " opened.");
				return true;
			}
		}

		else {
			if (!driver.getTitle().equals(title)) {
				System.out.println("No " + title + " found");
			}

			else {
				System.out.println(title + " opened.");
				return true;
			}
		}
		return false;
	}

	public StepDefinition() {
		super();
	}

}

//The following commented out lines were based on multi-page site
//	properties:
//	private String endpoint;

//	Getter/Setters:
//public String getEndpoint() {
//	return endpoint;
//}
//
//public void setEndpoint(String endpoint) {
//	this.endpoint = endpoint;
//}

//	Methods:
//public void goToEndpoint(String desiredEndpoint) {
//	setEndpoint(desiredEndpoint);
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	driver.navigate().to(getURL());
//}
//
//public void goToEndpoint(String desiredEndpoint, String variable) {
//	setEndpoint(desiredEndpoint + "/" + variable);
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	driver.navigate().to(getURL());
//}
//
//public String getURL() {
//	return getBaseURL() + getEndpoint();
//}
