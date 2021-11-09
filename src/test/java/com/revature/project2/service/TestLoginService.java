package com.revature.project2.service;

import java.security.SecureRandom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

		// Create password hash
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
		String encodedPassword = bCryptPasswordEncoder.encode(account.getPassword());
		account.setPassword(encodedPassword);
		
		//Save to repository
		testRepository.save(account);
		Assertions.assertEquals(1, testRepository.findAll().size()); // Ensure the information was stored
		System.out.println("accounts added to 'repository' and all accounts returned");

		// Hard coded login
		String username = "zachary.miller@revature.net";
		String password = "P@ssw0rd";

		// Get user Account
		Account user = testRepository.findByEmail(username);
		passwordInRepository = user.getPassword();

		// Validate provided password against one in repository
		BCryptPasswordEncoder bCryptPasswordEncoder2 =
			new BCryptPasswordEncoder(10, new SecureRandom());
		Assertions.assertTrue(bCryptPasswordEncoder2.matches(password, account.getPassword()));
		System.out.println("Password validation successful.");

		// Remove entries from the database
		for (Account accountIteration : testRepository.findAll()) {
			testRepository.delete(accountIteration.getId());
		}
	}

	@Test
	@DisplayName("Should fail to Authenicate user due to username issue")
	public void failAuthenticationDueToUsername() {
		// Print to console which test is being started
		System.out.println("\nEntering failAuthenticationUsername() test");

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

		// Create password hash
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
		String encodedPassword = bCryptPasswordEncoder.encode(account.getPassword());
		account.setPassword(encodedPassword);
			
		//Save to repository
		testRepository.save(account); // Save user to repository
		Assertions.assertEquals(1, testRepository.findAll().size()); // Ensure the information was stored
		System.out.println("accounts added to 'repository' and all accounts returned");

		// Hard coded login
		String username = "zachary.miller@revature.ne";
		String password = "P@ssw0rd";

		// Get user Account
		Account user = testRepository.findByEmail(username);
		
		boolean isUserNull = user == null;
		
		//Fail based on if username || password is empty or incorrect
		if(isUserNull) {
			Assertions.assertThrows(NullPointerException.class, () -> {
				passwordInRepository = user.getPassword();
			});
			System.out.println("No match for user was found");
		}
		
		else {
			passwordInRepository = user.getPassword();
			BCryptPasswordEncoder bCryptPasswordEncoder2 =
				new BCryptPasswordEncoder(10, new SecureRandom());
			Assertions.assertFalse(bCryptPasswordEncoder2.matches(password, account.getPassword()));
			System.out.println("User match was found, but validation was not successful");
		}
			
			
		// Remove entries from the database
		for (Account accountIteration : testRepository.findAll()) {
			testRepository.delete(accountIteration.getId());
		}
	}
	
	@Test
	@DisplayName("Should fail to Authenicate user due to password issue.")
	public void failAuthenticationDueToPassword() {
		// Print to console which test is being started
		System.out.println("\nEntering failAuthenticationDueToPassword() test");

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

		// Create password hash
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
		String encodedPassword = bCryptPasswordEncoder.encode(account.getPassword());
		account.setPassword(encodedPassword);
			
		//Save to repository
		testRepository.save(account); // Save user to repository
		Assertions.assertEquals(1, testRepository.findAll().size()); // Ensure the information was stored
		System.out.println("accounts added to 'repository' and all accounts returned");

		// Hard coded login
		String username = "zachary.miller@revature.net";
		String password = "P@ssw0r";

		// Get user Account
		Account user = testRepository.findByEmail(username);
		
		boolean isUserNull = user == null;
		
		//Fail based on if username || password is empty or incorrect
		if(isUserNull) {
			Assertions.assertThrows(NullPointerException.class, () -> {
				passwordInRepository = user.getPassword();
			});
			System.out.println("No match for user was found");
		}
		
		else {
			passwordInRepository = user.getPassword();
			BCryptPasswordEncoder bCryptPasswordEncoder2 =
				new BCryptPasswordEncoder(10, new SecureRandom());
			Assertions.assertFalse(bCryptPasswordEncoder2.matches(password, account.getPassword()));
			System.out.println("User match was found, but validation was not successful");
		}
			
			
		// Remove entries from the database
		for (Account accountIteration : testRepository.findAll()) {
			testRepository.delete(accountIteration.getId());
		}
	}
}
