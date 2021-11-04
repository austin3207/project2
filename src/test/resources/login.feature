Feature: Login Functionality

	Scenario: User login successful
		Given I am on /api/login
		When username is zachary.miller@revature.net
		And password is P@ssw0rd
		And Submit button is pressed
		Then I should be presented with my profile page