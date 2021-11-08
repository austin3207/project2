package com.revature.project2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.project2.model.Account;
import com.revature.project2.repo.TestAccountRepository;

public class TestLoginService {
	public static String passwordInRepository;

	@Test
	@DisplayName("Should authenticate user")
	public void authenticateUser() {
		// Print to console which test is being started
		System.out.println("\nEntering authenticateUser() test");

		// Create instance of repository
		TestAccountRepository testRepository = new TestAccountRepository();

		// Create accounts
		Account account = new Account();
		account.setEmail("zachary.miller@revature.net");
		account.setFirstName("Zachary");
		account.setLastName("Miller");
		account.setPassword("P@ssw0rd");

		Assertions.assertNotNull(account); // Ensure that the information is stored as an entity
		System.out.println("accounts added as entities");

		testRepository.save(account); // Save user to repository
		Assertions.assertEquals(1, testRepository.findAll().size()); // Ensure the information was stored
		System.out.println("accounts added to 'repository' and all accounts returned");

		// Hard coded login
		String username = "zachary.miller@revature.net";
		String password = "P@ssw0rd";

		// Get user Account
		Account user = testRepository.findByEmail(username);
		passwordInRepository = user.getPassword();

		// Validate provided password against one in repository
		Assertions.assertTrue(password.equals(passwordInRepository));

		// Remove entries from the database
		for (Account accountIteration : testRepository.findAll()) {
			testRepository.delete(accountIteration.getId());
		}
	}

	@Test
	@DisplayName("Should fail to Authenicate user")
	public void failAuthentication() {
		// Print to console which test is being started
		System.out.println("\nEntering failAuthentication() test");

		// Create instance of repository
		TestAccountRepository testRepository = new TestAccountRepository();

		// Create accounts
		Account account = new Account();
		account.setEmail("zachary.miller@revature.net");
		account.setFirstName("Zachary");
		account.setLastName("Miller");
		account.setPassword("P@ssw0rd");

		Assertions.assertNotNull(account); // Ensure that the information is stored as an entity
		System.out.println("accounts added as entities");

		testRepository.save(account); // Save user to repository
		Assertions.assertEquals(1, testRepository.findAll().size()); // Ensure the information was stored
		System.out.println("accounts added to 'repository' and all accounts returned");

		// Failure do to username being empty
		// Hard coded login
		String username = " ";
		String password = "P@ssw0rd";

		// Get user Account
		Account user = testRepository.findByEmail(username);
		
		//Fail based on if username || password is empty or incorrect
		if(username.isEmpty()) {
			Assertions.assertThrows(NullPointerException.class, () -> {
				passwordInRepository = user.getPassword();
			});
		}
		
		else if(password.isEmpty()) {
			Account userPasswordCheck = testRepository.findByEmail(username);
			passwordInRepository = userPasswordCheck.getPassword();
			Assertions.assertFalse(password.equals(passwordInRepository));
		}
			
			
		// Remove entries from the database
		for (Account accountIteration : testRepository.findAll()) {
			testRepository.delete(accountIteration.getId());
		}
	}
}
