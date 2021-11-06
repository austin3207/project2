package com.revature.project2.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverChrome {

	public static WebDriver getWebDriver(String browser) {
		DriverInformation driverInformation = new DriverDetails(); //New instance of DriverInformation
		String driverName = driverInformation.getDriverName(browser); //Get name of driver
		String driverLocation = driverInformation.getDriverLocation(browser); //Get location of driver
		System.setProperty(driverName, driverLocation); //Set system properties for current browser
		WebDriver driver = new ChromeDriver(); //Create instance
		return driver; 
	}
}
