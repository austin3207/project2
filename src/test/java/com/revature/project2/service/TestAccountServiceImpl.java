package com.revature.project2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.revature.project2.model.Account;
import com.revature.project2.repo.TestAccountRepository;

public class TestAccountServiceImpl {

	@Test
	@DisplayName("Should save account.")
	public void shouldSaveAccount() {
		// Print to console which test is starting
		System.out.println("\nEntering shouldSaveAccount() test");

		// Create new instance of the repository
		TestAccountRepository testRepository = new TestAccountRepository();

		// Create Account

		Account account = new Account();
		account.setEmail("zachary.miller@revature.net");
		account.setFirstName("Zachary");
		account.setLastName("Miller");
		account.setPassword("P@ssw0rd");

		// Ensure the Account object is not empty and print a line confirming
		Assertions.assertNotNull(account);
		System.out.println("account added as entity");

		/*
		 * Perform save() method and check to ensure that a findAll() call on the
		 * repository does not return empty
		 */
		testRepository.save(account);
		Assertions.assertFalse(testRepository.findAll().isEmpty());
		System.out.println("account added to 'repository'");

		// Print the Account object to the console
		for (Account accountsView : testRepository.findAll()) {
			System.out.println(accountsView);
		}

		// Remove all objects from the repository
		for (Account accountIteration : testRepository.findAll()) {
			testRepository.delete(accountIteration.getId());
		}
	}

	@Test
	@DisplayName("Should find all accounts.")
	public void shouldFindAllAccounts() {
		// Print to console which test is starting
		System.out.println("\nEntering shouldFindAllAccounts() test");

		// Create new instance of the repository
		TestAccountRepository testRepository = new TestAccountRepository();

		// Create Accounts
		Account account = new Account();
		account.setEmail("zachary.miller@revature.net");
		account.setFirstName("Zachary");
		account.setLastName("Miller");
		account.setPassword("P@ssw0rd");

		Account account2 = new Account();
		account2.setEmail("austin.rogers@revature.net");
		account2.setFirstName("Austin");
		account2.setLastName("Rogers");
		account2.setPassword("P@ssw0rd");

		// Ensure neither of the Account objects are empty and print a line confirming
		Assertions.assertNotNull(account);
		Assertions.assertNotNull(account2);
		System.out.println("accounts added as entities");

		/*
		 * Perform save() method on each and check to ensure that the size of the
		 * repository Matches the number of accounts created
		 */
		testRepository.save(account);
		testRepository.save(account2);
		Assertions.assertEquals(2, testRepository.findAll().size());
		System.out.println("accounts added to 'repository' and all accounts returned");

		// Print the Account objects to the console
		for (Account accountsView : testRepository.findAll()) {
			System.out.println(accountsView);
		}

		// Remove all objects from the repository
		for (Account accountIteration : testRepository.findAll()) {
			testRepository.delete(accountIteration.getId());
		}

	}

	@Test
	@DisplayName("Should find by Id")
	public void findById() {
		// Print to console which test is being started
		System.out.println("\nEntering findById() test");

		// Create instance of repository
		TestAccountRepository testRepository = new TestAccountRepository();

		// Create accounts
		Account account = new Account();
		account.setEmail("zachary.miller@revature.net");
		account.setFirstName("Zachary");
		account.setLastName("Miller");
		account.setPassword("P@ssw0rd");

		Account account2 = new Account();
		account2.setEmail("austin.rogers@revature.net");
		account2.setFirstName("Austin");
		account2.setLastName("Rogers");
		account2.setPassword("P@ssw0rd");

		Assertions.assertNotNull(account); // Ensure that the information is stored as an entity
		Assertions.assertNotNull(account2); // Ensure that the information is stored as an entity
		System.out.println("accounts added as entities");

		testRepository.save(account); // Perform method under test (call the repository method)
		testRepository.save(account2); // Perform method under test (call the repository method)
		Assertions.assertEquals(2, testRepository.findAll().size()); // Ensure the information was stored
		System.out.println("accounts added to 'repository' and all accounts returned");

		// Print out the information to console
		for (Account accountsView : testRepository.findAll()) {
			System.out.println(accountsView);
		}

		// Verify that the Account objects are being located by their ids
		for (Account accountIteration : testRepository.findAll()) {
			int id = accountIteration.getId(); // Get the id for the first object returned and store it

			/*
			 * Pass the stored id as an argument in the repository's findById() method
			 * Compare the active Account object from the for each loop with the Account
			 * object Returned by the method call to ensure they are the same object
			 */
			Assertions.assertTrue(testRepository.findById(id) == accountIteration);

			// Print a line to the console showing the id that was used and the result that
			// was pulled
			System.out.println("Account with id: " + id + " is " + testRepository.findById(id));
		}
		// Print a line confirming that the objects match
		System.out.println("Find by id returns same object created and saved to database");

		// Remove entries from the database
		for (Account accountIteration : testRepository.findAll()) {
			testRepository.delete(accountIteration.getId());
		}
	}

	@Test
	@DisplayName("Should find Account object by Email")
	public void findByEmail() {
		// Print to console which test is being started
		System.out.println("\nEntering findByEmail() test");

		// Create instance of repository
		TestAccountRepository testRepository = new TestAccountRepository();

		// Create accounts
		Account account = new Account();
		account.setEmail("zachary.miller@revature.net");
		account.setFirstName("Zachary");
		account.setLastName("Miller");
		account.setPassword("P@ssw0rd");

		Account account2 = new Account();
		account2.setEmail("austin.rogers@revature.net");
		account2.setFirstName("Austin");
		account2.setLastName("Rogers");
		account2.setPassword("P@ssw0rd");

		Assertions.assertNotNull(account); // Ensure that the information is stored as an entity
		Assertions.assertNotNull(account2); // Ensure that the information is stored as an entity
		System.out.println("accounts added as entities");

		testRepository.save(account); // Perform method under test (call the repository method)
		testRepository.save(account2); // Perform method under test (call the repository method)
		Assertions.assertEquals(2, testRepository.findAll().size()); // Ensure the information was stored
		System.out.println("accounts added to 'repository' and all accounts returned");

		// Print out the information to console
		for (Account accountsView : testRepository.findAll()) {
			System.out.println(accountsView);
		}


		// Verify that the Account objects are being located by their email
		for (Account accountIteration : testRepository.findAll()) {
			String email = accountIteration.getEmail(); // Get the id for the first object returned and store it

			/*
			 * Pass the stored id as an argument in the repository's findById() method
			 * Compare the active Account object from the for each loop with the Account
			 * object Returned by the method call to ensure they are the same object
			 */
			Assertions.assertTrue(testRepository.findByEmail(email) == accountIteration);

			// Print a line to the console showing the id that was used and the result that
			// was pulled
			System.out.println("Account with email: " + email + " is " + testRepository.findByEmail(email));
		}
		// Print a line confirming that the objects match
		System.out.println("Find by email returns same object created and saved to database");

		// Remove entries from the database
		for (Account accountIteration : testRepository.findAll()) {
			testRepository.delete(accountIteration.getId());
		}
	}

	@Test
	@DisplayName("Should update Account object")
	public void update() {
		// Print to console which test is starting
		System.out.println("\nEntering update() test");

		// Create new instance of the repository
		TestAccountRepository testRepository = new TestAccountRepository();

		// Create Account
		Account account = new Account();
		account.setEmail("zachary.miller@revature.net");
		account.setFirstName("Zachary");
		account.setLastName("Miller");
		account.setPassword("P@ssw0rd");

		// Ensure the Account object is not empty and print a line confirming
		Assertions.assertNotNull(account);
		System.out.println("account added as entity");

		/*
		 * Perform save() method and check to ensure that a findAll() call on the
		 * repository does not return empty
		 */
		testRepository.save(account);
		Assertions.assertFalse(testRepository.findAll().isEmpty());
		System.out.println("account added to 'repository'");

		// Print the Account object to the console
		for (Account accountsView : testRepository.findAll()) {
			System.out.println(accountsView);
		}

		/*
		 * Given an Account object's id Modify the email property of the object Perform
		 * assertions that the modification has occurred Print the object values
		 */
		int id = account.getId();
		String newEmail = "new.email@revature.net";
		Account thisAccount = testRepository.findById(id);
		thisAccount.setEmail(newEmail);
		testRepository.update(id, thisAccount);
		Assertions.assertTrue(testRepository.findById(id).getEmail().equals(newEmail));
		System.out.println("Account with modified email: " + testRepository.findById(id));

		// Again with first name
		String newFirstName = "NewFirstName";
		thisAccount.setFirstName(newFirstName);
		testRepository.update(id, thisAccount);
		Assertions.assertTrue(testRepository.findById(id).getFirstName().equals(newFirstName));
		System.out.println("Account with modified first name: " + testRepository.findById(id));

		// Again with last name
		String newLastName = "NewLastName";
		thisAccount.setLastName(newLastName);
		testRepository.update(id, thisAccount);
		Assertions.assertTrue(testRepository.findById(id).getLastName().equals(newLastName));
		System.out.println("Account with modified last name: " + testRepository.findById(id));

		// Again with password
		String newPassword = "NewPassword";
		thisAccount.setPassword(newPassword);
		testRepository.update(id, thisAccount);
		Assertions.assertTrue(testRepository.findById(id).getPassword().equals(newPassword));
		System.out.println("Account with modified password: " + testRepository.findById(id));

		// Remove all objects from the repository
		for (Account accountIteration : testRepository.findAll()) {
			testRepository.delete(accountIteration.getId());
		}
	}

	@Test
	@DisplayName("Should delete an account according to their id")
	public void delete() {
		// Print to console which test is being started
		System.out.println("\nEntering delete() test");

		// Create instance of repository
		TestAccountRepository testRepository = new TestAccountRepository();

		// Create accounts
		Account account = new Account();
		account.setEmail("zachary.miller@revature.net");
		account.setFirstName("Zachary");
		account.setLastName("Miller");
		account.setPassword("P@ssw0rd");

		Account account2 = new Account();
		account2.setEmail("austin.rogers@revature.net");
		account2.setFirstName("Austin");
		account2.setLastName("Rogers");
		account2.setPassword("P@ssw0rd");

		Assertions.assertNotNull(account); // Ensure that the information is stored as an entity
		Assertions.assertNotNull(account2); // Ensure that the information is stored as an entity
		System.out.println("accounts added as entities");

		testRepository.save(account); // Perform method under test (call the repository method)
		testRepository.save(account2); // Perform method under test (call the repository method)
		Assertions.assertEquals(2, testRepository.findAll().size()); // Ensure the information was stored
		System.out.println("accounts added to 'repository' and all accounts returned");

		// Print out the information to console
		for (Account accountsView : testRepository.findAll()) {
			System.out.println(accountsView);
		}

		/*
		 * Get the id of the first object 
     * Pass the stored id as an argument in the repository's findById() method
		 * Compare the object with the Account object 
		 * If the same, delete the object
		 */
		int id = account.getId(); // Get the id for the first object returned and store it
		Account thisAccount = testRepository.findById(id);
		if (thisAccount == account) {
			testRepository.delete(id);
			Assertions.assertThrows(NullPointerException.class, () -> {
				testRepository.findById(id).equals(account);
			});
			Assertions.assertEquals(1, testRepository.findAll().size());
		}
    
		for (Account accountIteration : testRepository.findAll()) {
			testRepository.delete(accountIteration.getId());
		}
	}

}
