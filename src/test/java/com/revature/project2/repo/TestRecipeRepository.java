package com.revature.project2.repo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.revature.project2.model.Recipe;

public class TestRecipeRepository {
	private int recipeId = 1;
	private int userId = 1;

	private List<Recipe> recipeRepository = new CopyOnWriteArrayList<Recipe>();

	public List<Recipe> findAll() {
		return recipeRepository;
	}

	public Recipe findById(int id) {
		for (Recipe recipe : recipeRepository) {
			if (recipe.getRecipeId() == id) {
				return recipe;
			}
		}
		return null;
	}

	public Recipe findByCategory(String category) {
		for (Recipe recipe : recipeRepository) {
			if (recipe.getCategory().equals(category)) {
				return recipe;
			}
		}
		return null;
	}

	public void save(Recipe recipe) {
		recipe.setUserId(userId);
		recipe.setRecipeId(recipeId);
		recipeRepository.add(recipe);
		recipeId++;
		userId++;
	}

	public void update(int id, Recipe recipe) {
		for (Recipe accountIteration : recipeRepository) {
			if (accountIteration.getRecipeId() == id) {
				recipeRepository.add(recipe);
			}
		}
	}

	public void delete(int id) {
		for (Recipe recipe : recipeRepository) {
			if (recipe.getRecipeId() == id) {
				recipeRepository.remove(recipe);
			}
		}
	}
}
