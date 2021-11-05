package com.revature.project2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.project2.model.Recipe;
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{
	
	public List<Recipe> findByCategory(String category);
}
