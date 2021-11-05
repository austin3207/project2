package com.revature.project2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project2.model.Recipe;
import com.revature.project2.repo.RecipeRepository;

@RestController
@RequestMapping("/api")
public class RecipeController {
	@Autowired
	RecipeRepository recipeRepository;
	
	@GetMapping("/recipes")
	public List<Recipe> findAll() {
		// TODO Auto-generated method stub
		return recipeRepository.findAll();
	}

	@GetMapping("/recipes/{id}")
	public Recipe findById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return recipeRepository.findById(id).get();
	}

	@GetMapping("/findByCategory/{category}")
	public List<Recipe> findByCategory(@PathVariable String category) {
		// TODO Auto-generated method stub
		return recipeRepository.findByCategory(category);
	}

	@PostMapping("/recipes")
	public void save(Recipe recipe) {
		// TODO Auto-generated method stub
		recipeRepository.save(recipe);
	}

	@PutMapping("/recipes/{id}")
	public void update(int id, Recipe recipe) {
		// TODO Auto-generated method stub
		recipeRepository.save(recipe);
	}

	@DeleteMapping("/recipes/{id}")
	public void delete(int id) {
		// TODO Auto-generated method stub
		recipeRepository.deleteById(id);
	}
}
