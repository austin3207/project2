Feature: Recipes

	Scenario: Add a recipe
		Given I am an authenticated user
		When I click new recipe
		And I provide name as Recipe
		And I provide category as Steak
		And I provide description as Best. Steak. Ever.
		And I provide prepMethod as Grill the steak
		And I provide ingredients as ingredients
		And Click save
		Then The recipe should be saved
		And I should see the recipe
		
#		Scenario: Edit option
#		Given I am an authenticated user
#		When I am the owner of a recipe
#		Then I should have an option to edit the recipe
#		
#		Scenario: Delete option
#		Given I am an authenticated user
#		When I am the owner of a recipe
#		Then I should have an option to delete the recipe
#		
#		Scenario: Edit a recipe name
#		Given I am an authenticated user
#		When I click to edit a recipe
#		And I provide name as Edited Recipe
#		And I click save
#		Then The recipe name should be updated
#		And I should see the recipe
		