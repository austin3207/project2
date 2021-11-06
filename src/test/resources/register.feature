Feature: Registration Functionality

	Scenario: Registration Navigation
		Given I am on the login page
		And The option is given to register
		When I click the register link
		Then A registration form appears
		
	Scenario: Successful Registration
		Given I am at the registration form
		When I enter first name as Zachary
		And I enter last name as Miller
		And I enter email as zachary.miller@revature.net
		And I enter password as P@ssw0rd
		And I click submit
		Then My profile should be created
		And I should see my account profile
		
	Scenario: Registration Cancellation
		Given I am at the registration form2
		When I click cancel
		Then The Form should close