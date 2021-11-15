package com.revature.project2.components;

public class RecipeComponent {
	private final String newRecipeIdentifier = ".btn";
	private final String ingredientsIdentifier = "ingredients";
	private final String nameIdentifier = "name";
	private final String categoryIdentifier = "category";
	private final String prepMethodIdentifier = "prepMethod";
	private final String descriptionIdentifier = "description";
	private final String imageIdentifier = "imagePath";
	private final String saveButtonIdentifier= ".btn-success";
	private final String editButtonIdentifier = ".btn-warning";
	private final String deleteButtonIdentifier = ".btn-danger";
	private final String logoutIdentifier = ".active strong";

	public String getNewRecipeIdentifier() {
		return newRecipeIdentifier;
	}

	public String getLogoutIdentifier() {
		return logoutIdentifier;
	}

	public String getEditButtonIdentifier() {
		return editButtonIdentifier;
	}

	public String getDeleteButtonIdentifier() {
		return deleteButtonIdentifier;
	}

	public String getSaveButtonIdentifier() {
		return saveButtonIdentifier;
	}

	public String getIngredientsIdentifier() {
		return ingredientsIdentifier;
	}

	public String getNameIdentifier() {
		return nameIdentifier;
	}

	public String getCategoryIdentifier() {
		return categoryIdentifier;
	}

	public String getPrepMethodIdentifier() {
		return prepMethodIdentifier;
	}

	public String getDescriptionIdentifier() {
		return descriptionIdentifier;
	}

	public String getImageIdentifier() {
		return imageIdentifier;
	}
}
