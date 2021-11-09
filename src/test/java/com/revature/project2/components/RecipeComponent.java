package com.revature.project2.components;

public class RecipeComponent {
	private final String ingredientsClassID = "recipe_ingredients";
	private String ingredientIdentifier;
	private final String ingredientsElementID = "recipe_ingredient" + ingredientIdentifier;
	private final String nameElementID = "recipe_name";
	private final String categoryElementID = "recipe_category";
	private final String addLikeElementID = "recipe_like";
	private final String removeLikeElementID = "recipe_unlike";
	private final String prepMethodElementID = "recipe_prep_method";
	private final String descriptionElementID = "recipe_description";
	private final String imageElementID = "recipe_image";
	private final String saveButtonElementID = "recipe_save";
	private final String editButtonElementID = "recipe_edit";
	private final String deleteButtonElementID = "recipe_delete";

	public String getEditButtonElementID() {
		return editButtonElementID;
	}

	public String getDeleteButtonElementID() {
		return deleteButtonElementID;
	}

	public String getSaveButtonElementID() {
		return saveButtonElementID;
	}

	public String getIngredientsClassID() {
		return ingredientsClassID;
	}

	public String getIngredientsElementID() {
		return ingredientsElementID;
	}

	public String getNameElementID() {
		return nameElementID;
	}

	public String getCategoryElementID() {
		return categoryElementID;
	}

	public String getAddLikeElementID() {
		return addLikeElementID;
	}

	public String getRemoveLikeElementID() {
		return removeLikeElementID;
	}

	public String getPrepMethodElementID() {
		return prepMethodElementID;
	}

	public String getDescriptionElementID() {
		return descriptionElementID;
	}

	public String getImageElementID() {
		return imageElementID;
	}

	public String getIngredientIdentifier() {
		return ingredientIdentifier;
	}

	public void setIngredientIdentifier(String ingredientIdentifier) {
		this.ingredientIdentifier = ingredientIdentifier;
	}
}
