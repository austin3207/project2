package com.revature.project2.util;

public class DriverDetails implements DriverInformation {
	private String[] availableDrivers = {"Chrome"};

	@Override
	public String getDriverName(String browser) {
		String browserType = browser.toLowerCase();
		
		switch(browserType) {
		
		case "chrome": 
			return "webdriver.chrome.driver";
		default:
			return "There is not currently a " + browserType + "driver available. Please select from the following." + availableDrivers.toString();
		}
		
	}
	
	@Override
	public String getDriverLocation(String browser) {
		String browserType = browser.toLowerCase();
		String driverDirectory = ".\\src\\test\\resources\\drivers\\";
		
		switch(browserType) {
		
		case "chrome":
			return driverDirectory + "chromedriver.exe";
			
		default:
			return null;
		}
	}
}
