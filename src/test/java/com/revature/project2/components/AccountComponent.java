package com.revature.project2.components;

public class AccountComponent {
	private final String endpoint = "account";
	private String titleElementID;
	private String usernameElementID;

	public String getTitleElementID() {
		return titleElementID;
	}

	public void setTitleElementID(String titleElementID) {
		this.titleElementID = titleElementID;
	}

	public String getUsernameElementID() {
		return usernameElementID;
	}

	public void setUsernameElementID(String usernameElementID) {
		this.usernameElementID = usernameElementID;
	}

	public String getEndpoint() {
		return endpoint;
	}

}
