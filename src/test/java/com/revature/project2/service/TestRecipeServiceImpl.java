package com.revature.project2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.project2.model.Recipe;
import com.revature.project2.repo.TestRecipeRepository;

public class TestRecipeServiceImpl {

	@Test
	@DisplayName("Should save Recipe.")
	public void shouldSaveRecipe() {
		// Print to console which test is starting
		System.out.println("\nEntering shouldSaveRecipe() test");

		// Create new instance of the repository
		TestRecipeRepository testRepository = new TestRecipeRepository();

		// Create Recipe
		Recipe recipe = new Recipe();
		String[] ingredients = { "Bread", "Meat", "Cheese", "Lettuce" };
		recipe.setName("Awesome Burger");
		recipe.setCategory("Burgers");
		recipe.setNumberOfLikes(0);
		recipe.setPrepMethod("Do some stuff to prep");
		recipe.setDescription("This is the best burger you'll ever eat!");
		recipe.setIngredients(ingredients);

		// Ensure the Recipe object is not empty and print a line confirming
		Assertions.assertNotNull(recipe);
		System.out.println("Recipe added as entity");

		/*
		 * Perform save() method and check to ensure that a findAll() call on the
		 * repository does not return empty
		 */
		testRepository.save(recipe);
		Assertions.assertFalse(testRepository.findAll().isEmpty());
		System.out.println("Recipe added to 'repository'");

		// Print the Recipe object to the console
		for (Recipe recipesView : testRepository.findAll()) {
			System.out.println(recipesView);
		}

		// Remove all objects from the repository
		for (Recipe recipeIteration : testRepository.findAll()) {
			testRepository.delete(recipeIteration.getRecipeId());
		}
	}

	@Test
	@DisplayName("Should find all Recipes.")
	public void shouldFindAllRecipes() {
		// Print to console which test is starting
		System.out.println("\nEntering shouldFindAllRecipes() test");

		// Create new instance of the repository
		TestRecipeRepository testRepository = new TestRecipeRepository();

		// Create Recipes
		Recipe recipe = new Recipe();
		String[] ingredients = { "Bread", "Meat", "Cheese", "Lettuce" };
		recipe.setName("Awesome Burger");
		recipe.setCategory("Burgers");
		recipe.setNumberOfLikes(0);
		recipe.setPrepMethod("Do some stuff to prep");
		recipe.setDescription("This is the best burger you'll ever eat!");
		recipe.setIngredients(ingredients);

		Recipe recipe2 = new Recipe();
		String[] ingredients2 = { "Eggs", "Meat", "Cheese", "Salsa" };
		recipe2.setName("Amazing Omelette");
		recipe2.setCategory("Breakfast");
		recipe2.setNumberOfLikes(0);
		recipe2.setPrepMethod("Make the omelette");
		recipe2.setDescription("This omelette will make you cry!");
		recipe2.setIngredients(ingredients2);

		// Ensure neither of the Recipe objects are empty and print a line confirming
		Assertions.assertNotNull(recipe);
		Assertions.assertNotNull(recipe2);
		System.out.println("Recipes added as entities");

		/*
		 * Perform save() method on each and check to ensure that the size of the
		 * repository Matches the number of Recipes created
		 */
		testRepository.save(recipe);
		testRepository.save(recipe2);
		Assertions.assertEquals(2, testRepository.findAll().size());
		System.out.println("Recipes added to 'repository' and all Recipes returned");

		// Print the Recipe objects to the console
		for (Recipe recipesView : testRepository.findAll()) {
			System.out.println(recipesView);
		}

		// Remove all objects from the repository
		for (Recipe recipeIteration : testRepository.findAll()) {
			testRepository.delete(recipeIteration.getRecipeId());
		}

	}

	@Test
	@DisplayName("Should find by Id")
	public void findById() {
		// Print to console which test is being started
		System.out.println("\nEntering findById() test");

		// Create instance of repository
		TestRecipeRepository testRepository = new TestRecipeRepository();

		// Create Recipes
		Recipe recipe = new Recipe();
		String[] ingredients = { "Bread", "Meat", "Cheese", "Lettuce" };
		recipe.setName("Awesome Burger");
		recipe.setCategory("Burgers");
		recipe.setNumberOfLikes(0);
		recipe.setPrepMethod("Do some stuff to prep");
		recipe.setDescription("This is the best burger you'll ever eat!");
		recipe.setIngredients(ingredients);

		Recipe recipe2 = new Recipe();
		String[] ingredients2 = { "Eggs", "Meat", "Cheese", "Salsa" };
		recipe2.setName("Amazing Omelette");
		recipe2.setCategory("Breakfast");
		recipe2.setNumberOfLikes(0);
		recipe2.setPrepMethod("Make the omelette");
		recipe2.setDescription("This omelette will make you cry!");
		recipe2.setIngredients(ingredients2);

		Assertions.assertNotNull(recipe); // Ensure that the information is stored as an entity
		Assertions.assertNotNull(recipe2); // Ensure that the information is stored as an entity
		System.out.println("Recipes added as entities");

		testRepository.save(recipe); // Perform method under test (call the repository method)
		testRepository.save(recipe2); // Perform method under test (call the repository method)
		Assertions.assertEquals(2, testRepository.findAll().size()); // Ensure the information was stored
		System.out.println("Recipes added to 'repository' and all Recipes returned");

		// Print out the information to console
		for (Recipe recipesView : testRepository.findAll()) {
			System.out.println(recipesView);
		}

		// Verify that the Recipe objects are being located by their ids
		for (Recipe recipeIteration : testRepository.findAll()) {
			int id = recipeIteration.getRecipeId(); // Get the id for the first object returned and store it

			/*
			 * Pass the stored id as an argument in the repository's findById() method
			 * Compare the active Recipe object from the for each loop with the Recipe
			 * object Returned by the method call to ensure they are the same object
			 */
			Assertions.assertTrue(testRepository.findById(id) == recipeIteration);

			// Print a line to the console showing the id that was used and the result that
			// was pulled
			System.out.println("Recipe with id: " + id + " is " + testRepository.findById(id));
		}
		// Print a line confirming that the objects match
		System.out.println("Find by id returns same object created and saved to database");

		// Remove entries from the database
		for (Recipe RecipeIteration : testRepository.findAll()) {
			testRepository.delete(RecipeIteration.getRecipeId());
		}
	}

	@Test
	@DisplayName("Should find Recipe object by Category")
	public void findByCategory() {
		// Print to console which test is being started
		System.out.println("\nEntering findByCategory() test");

		// Create instance of repository
		TestRecipeRepository testRepository = new TestRecipeRepository();

		// Create Recipes
		Recipe recipe = new Recipe();
		String[] ingredients = { "Bread", "Meat", "Cheese", "Lettuce" };
		recipe.setName("Awesome Burger");
		recipe.setCategory("Burgers");
		recipe.setNumberOfLikes(0);
		recipe.setPrepMethod("Do some stuff to prep");
		recipe.setDescription("This is the best burger you'll ever eat!");
		recipe.setIngredients(ingredients);

		Recipe recipe2 = new Recipe();
		String[] ingredients2 = { "Eggs", "Meat", "Cheese", "Salsa" };
		recipe2.setName("Amazing Omelette");
		recipe2.setCategory("Breakfast");
		recipe2.setNumberOfLikes(0);
		recipe2.setPrepMethod("Make the omelette");
		recipe2.setDescription("This omelette will make you cry!");
		recipe2.setIngredients(ingredients2);

		Assertions.assertNotNull(recipe); // Ensure that the information is stored as an entity
		Assertions.assertNotNull(recipe2); // Ensure that the information is stored as an entity
		System.out.println("Recipes added as entities");

		testRepository.save(recipe); // Perform method under test (call the repository method)
		testRepository.save(recipe2); // Perform method under test (call the repository method)
		Assertions.assertEquals(2, testRepository.findAll().size()); // Ensure the information was stored
		System.out.println("Recipes added to 'repository' and all Recipes returned");

		// Print out the information to console
		for (Recipe recipesView : testRepository.findAll()) {
			System.out.println(recipesView);
		}

		// Verify that the Recipe objects are being located by their category
		for (Recipe recipeIteration : testRepository.findAll()) {
			String category = recipeIteration.getCategory(); // Get the category for the first object returned and store
																// it

			/*
			 * Pass the stored category as an argument in the repository's findByCategory()
			 * method Compare the active Recipe object from the for each loop with the
			 * Recipe object Returned by the method call to ensure they are the same object
			 */
			Assertions.assertTrue(testRepository.findByCategory(category) == recipeIteration);

			// Print a line to the console showing the category that was used and the result
			// that
			// was pulled
			System.out.println("Recipe with category: " + category + " is " + testRepository.findByCategory(category));
		}
		// Print a line confirming that the objects match
		System.out.println("Find by category returns same object created and saved to database");

		// Remove entries from the database
		for (Recipe recipeIteration : testRepository.findAll()) {
			testRepository.delete(recipeIteration.getRecipeId());
		}
	}

	@Test
	@DisplayName("Should update Recipe object")
	public void update() {
		// Print to console which test is starting
		System.out.println("\nEntering update() test");

		// Create new instance of the repository
		TestRecipeRepository testRepository = new TestRecipeRepository();

		// Create Recipe
		Recipe recipe = new Recipe();
		String[] ingredients = { "Bread", "Meat", "Cheese", "Lettuce" };
		recipe.setName("Awesome Burger");
		recipe.setCategory("Burgers");
		recipe.setNumberOfLikes(0);
		recipe.setPrepMethod("Do some stuff to prep");
		recipe.setDescription("This is the best burger you'll ever eat!");
		recipe.setIngredients(ingredients);

		// Ensure the Recipe object is not empty and print a line confirming
		Assertions.assertNotNull(recipe);
		System.out.println("Recipe added as entity");

		/*
		 * Perform save() method and check to ensure that a findAll() call on the
		 * repository does not return empty
		 */
		testRepository.save(recipe);
		Assertions.assertFalse(testRepository.findAll().isEmpty());
		System.out.println("Recipe added to 'repository'");

		// Print the Recipe object to the console
		for (Recipe recipesView : testRepository.findAll()) {
			System.out.println(recipesView);
		}

		/*
		 * Given an Recipe object's id Modify the category property of the object
		 * Perform assertions that the modification has occurred Print the object values
		 */
		int id = recipe.getRecipeId();
		String newCategory = "Burgers";
		Recipe thisRecipe = testRepository.findById(id);
		thisRecipe.setCategory(newCategory);
		testRepository.update(id, thisRecipe);
		Assertions.assertTrue(testRepository.findById(id).getCategory().equals(newCategory));
		System.out.println("Recipe with modified category: " + testRepository.findById(id));

		// Again with name
		String newName = "NewName";
		thisRecipe.setName(newName);
		testRepository.update(id, thisRecipe);
		Assertions.assertTrue(testRepository.findById(id).getName().equals(newName));
		System.out.println("Recipe with modified name: " + testRepository.findById(id));

		// Again with number of likes
		int updateLikes = 1;
		thisRecipe.setNumberOfLikes(updateLikes);
		testRepository.update(id, thisRecipe);
		Assertions.assertTrue(testRepository.findById(id).getNumberOfLikes() == updateLikes);
		System.out.println("Recipe with modified number of likes: " + testRepository.findById(id));

		// Again with prep method
		String newPrepMethod = "Do it like this instead";
		thisRecipe.setPrepMethod(newPrepMethod);
		testRepository.update(id, thisRecipe);
		Assertions.assertTrue(testRepository.findById(id).getPrepMethod().equals(newPrepMethod));
		System.out.println("Recipe with modified prep method: " + testRepository.findById(id));

		// Again with description
		String newDescription = "BURGER YEAH!";
		thisRecipe.setDescription(newDescription);
		testRepository.update(id, thisRecipe);
		Assertions.assertTrue(testRepository.findById(id).getDescription().equals(newDescription));
		System.out.println("Recipe with modified description: " + testRepository.findById(id));

		// Again with ingredients
		String[] newIngredients = { "Bun", "Meat", "Cheese", "Lettuce", "Tomato" };
		thisRecipe.setIngredients(newIngredients);
		testRepository.update(id, thisRecipe);
		Assertions.assertTrue(testRepository.findById(id).getIngredients().equals(newIngredients));
		System.out.println("Recipe with modified ingredients: " + testRepository.findById(id));

		// Remove all objects from the repository
		for (Recipe recipeIteration : testRepository.findAll()) {
			testRepository.delete(recipeIteration.getRecipeId());
		}
	}

	@Test
	@DisplayName("Should delete an Recipe according to its id")
	public void delete() {
		// Print to console which test is being started
		System.out.println("\nEntering delete() test");

		// Create instance of repository
		TestRecipeRepository testRepository = new TestRecipeRepository();

		// Create Recipes
		Recipe recipe = new Recipe();
		String[] ingredients = { "Bread", "Meat", "Cheese", "Lettuce" };
		recipe.setName("Awesome Burger");
		recipe.setCategory("Burgers");
		recipe.setNumberOfLikes(0);
		recipe.setPrepMethod("Do some stuff to prep");
		recipe.setDescription("This is the best burger you'll ever eat!");
		recipe.setIngredients(ingredients);

		Recipe recipe2 = new Recipe();
		String[] ingredients2 = { "Eggs", "Meat", "Cheese", "Salsa" };
		recipe2.setName("Amazing Omelette");
		recipe2.setCategory("Breakfast");
		recipe2.setNumberOfLikes(0);
		recipe2.setPrepMethod("Make the omelette");
		recipe2.setDescription("This omelette will make you cry!");
		recipe2.setIngredients(ingredients2);

		Assertions.assertNotNull(recipe); // Ensure that the information is stored as an entity
		Assertions.assertNotNull(recipe2); // Ensure that the information is stored as an entity
		System.out.println("Recipes added as entities");

		testRepository.save(recipe); // Perform method under test (call the repository method)
		testRepository.save(recipe2); // Perform method under test (call the repository method)
		Assertions.assertEquals(2, testRepository.findAll().size()); // Ensure the information was stored
		System.out.println("Recipes added to 'repository' and all Recipes returned");

		// Print out the information to console
		for (Recipe recipesView : testRepository.findAll()) {
			System.out.println(recipesView);
		}

		/*
		 * Get the id of the first object Pass the stored id as an argument in the
		 * repository's findById() method Compare the object with the Recipe object If
		 * the same, delete the object
		 */
		int id = recipe.getRecipeId(); // Get the id for the first object returned and store it
		Recipe thisRecipe = testRepository.findById(id);
		if (thisRecipe == recipe) {
			System.out.println("Deleting recipe: " + testRepository.findById(id).toString());
			testRepository.delete(id);
			Assertions.assertThrows(NullPointerException.class, () -> {
				testRepository.findById(id).equals(recipe);
			});
			Assertions.assertEquals(1, testRepository.findAll().size());
			System.out.println("Number of recipes in repository: " + testRepository.findAll().size());
		}

		for (Recipe recipeIteration : testRepository.findAll()) {
			testRepository.delete(recipeIteration.getRecipeId());
		}
	}

}
