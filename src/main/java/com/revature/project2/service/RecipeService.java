package com.revature.project2.service;

import java.util.List;

import com.revature.project2.model.Recipe;

public interface RecipeService {
	
	public List<Recipe> findAll();
	public Recipe findById(int id);
	public List<Recipe> findByCategory(String category);
	public void save(Recipe recipe);
	public void update(int id, Recipe recipe);
	public void delete(int id);
}
