package com.revature.project2.components;

public class RegisterComponent {
	private final String emailIdentifier = "email";
	private final String firstNameIdentifier = "firstName";
	private final String LastNameIdentifier = "lastName";
	private final String passwordIdentifier = "password";
	private final String confirmPasswordIdentifier = "password2";
	private final String submitIdentifier = ".btn";
	private final String cancelIdentifier = "Sign In";

	public String getCancelIdentifier() {
		return cancelIdentifier;
	}

	public String getSubmitIdentifier() {
		return submitIdentifier;
	}

	public String getEmailIdentifier() {
		return emailIdentifier;
	}

	public String getFirstNameIdentifier() {
		return firstNameIdentifier;
	}

	public String getLastNameIdentifier() {
		return LastNameIdentifier;
	}

	public String getPasswordIdentifier() {
		return passwordIdentifier;
	}

	public String getConfirmPasswordIdentifier() {
		return confirmPasswordIdentifier;
	}
}
