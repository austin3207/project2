package com.revature.project2.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.model.Recipe;
import com.revature.project2.repo.RecipeRepository;
@Service
public class RecipeServiceImp implements RecipeService {
	Logger log = LoggerFactory.getLogger(RecipeServiceImp.class);
	@Autowired
	RecipeRepository recipeRepository;
	@Override
	//Returns a list of all Recipes
	public List<Recipe> findAll() {
		return recipeRepository.findAll();
	}

	@Override
	//Returns specific Recipe based on ID
	public Recipe findById(int id) {
		Recipe recipe = new Recipe();
		try{
			recipe = recipeRepository.findById(id).get();
		}
		catch(NoSuchElementException e) {
			log.debug("Recipe does not exist.");
		}
		return recipe;
	}

	@Override
	//Returns list of Recipes in a specific Category
	public List<Recipe> findByCategory(String category) {
		return recipeRepository.findByCategory(category);
	}

	@Override
	//Saves new Recipe to repository
	public void save(Recipe recipe) {
		recipeRepository.save(recipe);
	}

	@Override
	//Updates existing Recipe by ID
	public void update(int id, Recipe recipe) {
		recipeRepository.save(recipe);
	}

	@Override
	//Delete Recipe by ID in repository
	public void delete(int id) {
		recipeRepository.deleteById(id);
	}

}
