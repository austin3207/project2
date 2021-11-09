package com.revature.project2.components;

public class RegisterComponent {
	private final String titleElementID = "Registration Form";
	private final String emailElementID = "register_email";
	private final String firstNameElementID = "register_firstName";
	private final String LastNameElementID = "register_lastName";
	private final String passwordElementID = "register_password";
	private final String submitElementID = "register_submit";
	private final String cancelElementID = "register_cancel";

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
}
