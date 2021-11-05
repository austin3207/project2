package com.revature.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.model.Recipe;
import com.revature.project2.repo.RecipeRepository;
@Service
public class RecipeServiceImp implements RecipeService {
	
	@Autowired
	RecipeRepository recipeRepository;
	@Override
	public List<Recipe> findAll() {
		// TODO Auto-generated method stub
		return recipeRepository.findAll();
	}

	@Override
	public Recipe findById(int id) {
		// TODO Auto-generated method stub
		return recipeRepository.findById(id).get();
	}

	@Override
	public List<Recipe> findByCategory(String category) {
		// TODO Auto-generated method stub
		return recipeRepository.findByCategory(category);
	}

	@Override
	public void save(Recipe recipe) {
		// TODO Auto-generated method stub
		recipeRepository.save(recipe);
	}

	@Override
	public void update(int id, Recipe recipe) {
		// TODO Auto-generated method stub
		recipeRepository.save(recipe);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		recipeRepository.deleteById(id);
	}

}
