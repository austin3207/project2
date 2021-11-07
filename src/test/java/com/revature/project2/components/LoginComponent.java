package com.revature.project2.components;

public class LoginComponent {
	private String usernameElementID;
	private String passwordElementID;
	private String submitElementID;
	private String titleElementID;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public String getTitleElementID() {
		return titleElementID;
	}

	public void setTitleElementID(String titleElementID) {
		this.titleElementID = titleElementID;
	}

	public String getSubmitElementID() {
		return submitElementID;
	}

	public void setSubmitElementID(String submitElementID) {
		this.submitElementID = submitElementID;
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

	public void setUsernameElementID(String usernameElementID) {
		this.usernameElementID = usernameElementID;
	}

	public String getPasswordElementID() {
		return passwordElementID;
	}

	public void setPasswordElementID(String passwordElementID) {
		this.passwordElementID = passwordElementID;
	}

	public LoginComponent() {
		super();
	}

	public LoginComponent(String usernameElementID, String passwordElementID) {
		super();
		this.usernameElementID = usernameElementID;
		this.passwordElementID = passwordElementID;
	}

	public void attemptLogin(String username, String password) {

	}
}
