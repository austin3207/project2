package com.revature.project2.service;

import java.util.List;

import com.revature.project2.model.Account;

public interface AccountService {
	
	public List<Account> findAll();
	public Account findById(int id);
	public List<Account> findByEmail(String email);
	public void save(Account account);
	public void update(int id, Account account);
	public void delete(int id);
	public boolean login(String email, String password);
	public void register(Account account);
}
