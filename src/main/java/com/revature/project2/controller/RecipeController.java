package com.revature.project2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.model.Recipe;
import com.revature.project2.repo.RecipeRepository;
import com.revature.project2.service.RecipeService;

@RestController
@RequestMapping("/api")
public class RecipeController {
	@Autowired
	RecipeService recipeService;
	
	//Endpoint for all existing recipes
	@GetMapping("/recipes")
	public List<Recipe> findAll() {
		
		return recipeService.findAll();
	}
	
	//Endpoint for specific recipes
	@GetMapping("/recipes/{id}")
	public Recipe findById(@PathVariable int id) {	
		return recipeService.findById(id);
	}
	
	//Endpoint for searching recipes by category
	@GetMapping("/findByCategory/{category}")
	public List<Recipe> findByCategory(@PathVariable String category) {		
		return recipeService.findByCategory(category);
	}
	//Endpoint for saving a new Recipe to the DB
	@PostMapping("/recipes")
	public void save(@RequestBody Recipe recipe) {	
		recipeService.save(recipe);
	}
	
	//Endpoint for updating existing Recipes
	@PutMapping("/recipes/{id}")
	public void update(int id, Recipe recipe) {
		recipeService.save(recipe);
	}
	
	//Endpoint for deleting existing Recipes
	@DeleteMapping("/recipes/{id}")
	public void delete(int id) {	
		recipeService.delete(id);
	}
}
