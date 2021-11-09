package com.revature.project2.components;

public class LoginComponent {
	private final String usernameElementID = "login_username";
	private final String passwordElementID = "login_password";
	private final String submitElementID = "login_submit";
	private final String titleElementID = "Login Page";
	private final String registerElementID = "login_register";
	private String username;
	private String password;
	
	public String getRegisterElementID() {
		return registerElementID;
	}

	public String getUsername() {
		return username;
	}

	public String getTitleElementID() {
		return titleElementID;
	}

	public String getSubmitElementID() {
		return submitElementID;
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

	public String getUsernameElementID() {
		return usernameElementID;
	}

	public String getPasswordElementID() {
		return passwordElementID;
	}

	public LoginComponent() {
		super();
	}

	public void attemptLogin(String username, String password) {

	}
}
