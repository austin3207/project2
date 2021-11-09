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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.revature.project2.model.Account;
import com.revature.project2.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	//Endpoint for accessing all existing Accounts
	@GetMapping("/accounts")
	public List<Account> findAll() {
		return accountService.findAll();
	}
	
	//Endpoint for finding Accounts by email
	@GetMapping("/accountsByEmail/{email}")
	public List<Account> findByEmail(@PathVariable String email) {
		return accountService.findByEmail(email);
	}
	
	//Endpoint for finding Accounts by ID
	@GetMapping("/accounts/{id}")
	public Account findById(@PathVariable int id) {
		return accountService.findById(id);
	}
	
	//Endpoint for saving an Account to the DB
	@PostMapping("/accounts")
	public void save(Account customer) {
		accountService.save(customer);

	}
	
	//Endpoint for updating an existing Account by ID
	@PutMapping("/accounts/{id}")
	public void update(int id, Account account) {
		accountService.save(account);

	}
	//Endpoint for deleting an Account by ID
	@DeleteMapping("/accounts/{id}")
	public void delete(int id) {
		accountService.delete(id);

	}
	
	//Endpoint for Login attempts
	@PostMapping("/login")
	public boolean login(@RequestBody Account account) {
		boolean validLogin = accountService.login(account.getEmail(), account.getPassword());
		return validLogin;
	}
	
	//Endpoint for Registering a new Account
	@PostMapping("/registration")
	public boolean register(@RequestBody Account account) {
		accountService.register(account);
		if(!accountService.findByEmail(account.getEmail()).isEmpty()) {
			return true;
		}
		return false;
	}	
}

