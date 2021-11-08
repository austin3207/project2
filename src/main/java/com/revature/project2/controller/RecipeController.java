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
	
	@GetMapping("/recipes")
	public List<Recipe> findAll() {
		// TODO Auto-generated method stub
		return recipeService.findAll();
	}

	@GetMapping("/recipes/{id}")
	public Recipe findById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return recipeService.findById(id);
	}

	@GetMapping("/findByCategory/{category}")
	public List<Recipe> findByCategory(@PathVariable String category) {
		// TODO Auto-generated method stub
		return recipeService.findByCategory(category);
	}

	@PostMapping("/recipes")
	public void save(@RequestBody Recipe recipe) {
		// TODO Auto-generated method stub
		recipeService.save(recipe);
	}

	@PutMapping("/recipes/{id}")
	public void update(int id, Recipe recipe) {
		// TODO Auto-generated method stub
		recipeService.save(recipe);
	}

	@DeleteMapping("/recipes/{id}")
	public void delete(int id) {
		// TODO Auto-generated method stub
		recipeService.delete(id);
	}
}
