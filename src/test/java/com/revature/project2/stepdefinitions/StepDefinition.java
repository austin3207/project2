package com.revature.project2.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
	
	public void goToEndpoint(String desiredEndpoint, String variable) {
		setEndpoint(desiredEndpoint + "/" + variable);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(getURL());
	}

	public String getURL() {
		return getBaseURL() + getEndpoint();
	}
	
	public boolean checkIfLinkExists(String linkText) {
		boolean exists = driver.findElement(By.linkText(linkText)).isDisplayed();
		return exists;
	}
	
	public void sendKeys(String elementID, String keys) {
		driver
		.findElement(By.id(elementID))
		.sendKeys(keys);
	}
	
	public void clickItem(String elementID) {
		driver
		.findElement(By.id(elementID))
		.click();
	}
	
	public String checkCurrentPage() {
		return driver.getCurrentUrl();
	}
	
	public boolean checkNewWindow(String title) {
		if(driver.getWindowHandles().size() > 1) {
//			String currentHandle = driver.getWindowHandles().iterator().next().toString();
			String otherHandle = driver.getWindowHandles().iterator().next().toString();
			if(!driver.getTitle().equals(title))  {
				driver.switchTo().window(otherHandle);
				if(!driver.getTitle().equals(title)) {
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
			if(!driver.getTitle().equals(title)) {
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
