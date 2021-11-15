package com.revature.project2.components;

public class LoginComponent {
	private final String usernameIdentifier = "email";
	private final String passwordIdentifier = ".ng-untouched";
	private final String submitIdentifier = ".btn";
	private final String titleIdentifier = "Login Page";
	private final String registerIdentifier = "Register here";
	private String username;
	private String password;
	
	public String getRegisterIdentifier() {
		return registerIdentifier;
	}

	public String getUsername() {
		return username;
	}

	public String getTitleIdentifier() {
		return titleIdentifier;
	}

	public String getSubmitIdentifier() {
		return submitIdentifier;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsernameIdentifier() {
		return usernameIdentifier;
	}

	public String getPasswordIdentifier() {
		return passwordIdentifier;
	}

	public LoginComponent() {
		super();
	}

	public void attemptLogin(String username, String password) {

	}
}
