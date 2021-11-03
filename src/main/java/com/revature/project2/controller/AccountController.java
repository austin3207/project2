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

import com.revature.project2.model.Account;
import com.revature.project2.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	AccountService accountService;

	@GetMapping("/accounts")
	public List<Account> findAll() {
		return accountService.findAll();
	}

	@GetMapping("/accountsByEmail/{email}")
	public List<Account> findByEmail(@PathVariable String email) {
		return accountService.findByEmail(email);
	}

	@GetMapping("/accounts/{id}")
	public Account findById(@PathVariable int id) {
		return accountService.findById(id);
	}

	@PostMapping("/accounts")
	public void save(Account customer) {
		accountService.save(customer);

	}

	@PostMapping("/accounts/bulk")
	public void save(Account[] accounts) {
		for (Account account : accounts) {
			accountService.save(account);
		}
	}

	@PutMapping("/accounts/{id}")
	public void update(int id, Account account) {
		accountService.save(account);

	}

	@DeleteMapping("/accounts/{id}")
	public void delete(int id) {
		accountService.delete(id);

	}
}

