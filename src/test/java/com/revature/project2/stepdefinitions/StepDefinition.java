package com.revature.project2.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.revature.project2.util.WebDriverChrome;

public class StepDefinition {
	private final WebDriver driver = WebDriverChrome.getWebDriver("chrome");
	private final String baseURL = "http://localhost:4200";
	private String classID;
	private String elementID;
	private String elementName;
	private String cssSelector;
	private String xPath;
	private String linkText;
	

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getLinkText() {
		return linkText;
	}

	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

	public String getCssSelector() {
		return cssSelector;
	}

	public void setCssSelector(String cssSelector) {
		this.cssSelector = cssSelector;
	}

	public String getxPath() {
		return xPath;
	}

	public void setxPath(String xPath) {
		this.xPath = xPath;
	}

	public String getElementID() {
		return elementID;
	}

	public void setElementID(String elementID) {
		this.elementID = elementID;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getBaseURL() {
		return baseURL;
	}
	
	public void goToSite() {
		driver.navigate().to(baseURL);
	}

	public boolean checkIfLinkExists(String linkText) {
		boolean exists = driver.findElement(By.linkText(linkText)).isDisplayed();
		return exists;
	}

	public void sendKeys(String elementID, String keys) {
		driver.findElement(By.id(elementID)).sendKeys(keys);
	}

	public void clickItem(String elementID) {
		driver.findElement(By.id(elementID)).click();
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
