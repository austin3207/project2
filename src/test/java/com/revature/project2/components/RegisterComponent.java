package com.revature.project2.components;

public class RegisterComponent {
	private final String endpoint = "register";
	private final String titleElementID = "Registration Form";
	private final String emailElementID = "email";
	private final String firstNameElementID = "firstName";
	private final String LastNameElementID = "lastName";
	private final String passwordElementID = "password";
	private final String submitElementID = "submit";
	private final String cancelElementID = "cancel";

	public String getCancelElementID() {
		return cancelElementID;
	}

	public String getSubmitElementID() {
		return submitElementID;
	}

	public String getTitleElementID() {
		return titleElementID;
	}

	public String getEmailElementID() {
		return emailElementID;
	}

	public String getFirstNameElementID() {
		return firstNameElementID;
	}

	public String getLastNameElementID() {
		return LastNameElementID;
	}

	public String getPasswordElementID() {
		return passwordElementID;
	}

	public String getEndpoint() {
		return endpoint;
	}

}
