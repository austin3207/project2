package com.revature.project2.stepdefinitions;

import com.revature.project2.components.LoginComponent;
import com.revature.project2.components.RecipeComponent;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Recipe extends StepDefinition {
	private String name;
	private String category;
	private String description;
	private String prepMethod;
	private String[] ingredients;
	
	RecipeComponent recipeComponent = new RecipeComponent();
	LoginComponent loginComponent = new LoginComponent();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrepMethod() {
		return prepMethod;
	}

	public void setPrepMethod(String prepMethod) {
		this.prepMethod = prepMethod;
	}

	public String[] getIngredients() {
		return ingredients;
	}

	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}

	

//	Scenario: Add a recipe
	@Given("^I am an authenticated user$")
	public void i_am_an_authenticated_user() {
		goToSite();
		sendKeys(loginComponent.getUsernameIdentifier(), "zachary.miller@revature.net", "id");
		sendKeys(loginComponent.getPasswordIdentifier(), "P@ssw0rd", "css selector");
		clickItem(loginComponent.getSubmitIdentifier(), "css selector");
	}
	
	@When("^I click new recipe$")
	public void i_click_new_recipe() {
		clickItem(recipeComponent.getNewRecipeIdentifier(), "css selector");
	}

	@When("^I provide name as Recipe$")
	public void i_provide_name_as_recipe() {
		sendKeys(recipeComponent.getNameIdentifier(), "Recipe", "id");
	}

	@And("^I provide category as Steak$")
	public void i_provide_category_as_steak() {
		sendKeys(recipeComponent.getCategoryIdentifier(), "Steak", "id");
	}

	@And("^I provide description as Best. Steak. Ever.$")
	public void i_provide_description_as_best_steak_ever() {
		sendKeys(recipeComponent.getDescriptionIdentifier(), "Best. Steak. Ever.", "id");
	}

	@And("^I provide prepMethod as Grill the steak$")
	public void i_provide_prep_method_as_grill_the_steak() {
		sendKeys(recipeComponent.getPrepMethodIdentifier(), "Grill the steak.", "id");
	}

	@And("^I provide ingredients as ingredients$")
	public void i_provide_ingredients_as_ingredients() {
		sendKeys(recipeComponent.getIngredientsIdentifier(), "Ingredients", "id");
	}

	@And("^Click save$")
	public void i_click_save() {
		clickItem(recipeComponent.getSaveButtonIdentifier(), "css selector");
	}

	@Then("^The recipe should be saved$")
	public void recipe_should_be_saved() {
		//Need to figure out how to verify
	}

	@And("^I should see the recipe$")
	public void i_should_see_the_recipe() {
		//Need to figure out how to verify
	}
	
	
//	//Scenario: Edit option
//	@Given("^I am an authenticated user$") 
//	public void i_am_an_authenticated_user2() {
//		goToSite();
//		sendKeys(loginComponent.getUsernameIdentifier(), "zachary.miller@revature.net", "id");
//		sendKeys(loginComponent.getPasswordIdentifier(), "P@ssw0rd", "id");
//		clickItem(loginComponent.getSubmitIdentifier(), "css selector");
//	}
//	
//	@When("^I am the owner of a recipe$")
//	public void i_am_the_owner_of_a_recipe() {
//		clickItem(recipeComponent.getNameIdentifier(), "id");
//	}
//	
//	@Then("^I should have an option to edit the recipe$")
//	public void i_should_have_an_option_to_edit_the_recipe() {
//		clickItem(recipeComponent.getEditButtonIdentifier());
//	}
//	
//	
////	Scenario: Edit a recipe name
//	@Given("^I am an authenticated user$")
//	public void i_am_an_authenticated_user4() {
//		goToSite();
//		sendKeys(loginComponent.getUsernameIdentifier(), "Zachary.miller@revature.net");
//		sendKeys(loginComponent.getPasswordIdentifier(), "P@ssw0rd");
//		clickItem(loginComponent.getSubmitIdentifier());
//	}
//	
//	@When("^I click to edit a recipe$")
//	public void i_click_to_edit_a_recipe() {
//		clickItem(recipeComponent.getNameIdentifier());
//		clickItem(recipeComponent.getEditButtonIdentifier());
//	}
//	
//	@And("^I provide name as Edited Recipe$")
//	public void i_provide_name_as_edited_recipe() {
//		clickItem(recipeComponent.getNameIdentifier());
//		sendKeys(recipeComponent.getNameIdentifier(), "Edited Recipe");
//	}
//	
//	@And("^I click save$")
//	public void i_click_save2() {
//		clickItem(recipeComponent.getSaveButtonIdentifier());
//	}
//	
//	@Then("^The recipe name should be updated$")
//	public void the_recipe_name_should_be_updated() {
//		recipeComponent.getNameIdentifier().equals("Edited Recipe");
//	}
//	
//	@And("^I should see the recipe$")
//	public void i_should_see_the_recipe2() {
//		//Need to determine what will allow for this
//	}
//	
//	
//	//Scenario: Delete option
//		@Given("^I am an authenticated user$") 
//		public void i_am_an_authenticated_user3() {
//			goToSite();
//			sendKeys(loginComponent.getUsernameIdentifier(), "Zachary.miller@revature.net");
//			sendKeys(loginComponent.getPasswordIdentifier(), "P@ssw0rd");
//			clickItem(loginComponent.getSubmitIdentifier());
//		}
//		
//		@When("^I am the owner of a recipe$")
//		public void i_am_the_owner_of_a_recipe2() {
//			clickItem(recipeComponent.getNameIdentifier());
//		}
//		
//		@Then("^I should have an option to delete the recipe$")
//		public void i_should_have_an_option_to_delete_the_recipe() {
//			clickItem(recipeComponent.getDeleteButtonIdentifier());
//		}
//
}
