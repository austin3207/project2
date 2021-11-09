package com.revature.project2.service;

import java.security.SecureRandom;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.revature.project2.model.Account;
import com.revature.project2.repo.AccountRepository;
@Service
public class AccountServiceImp implements AccountService {
	Logger log = LoggerFactory.getLogger(AccountServiceImp.class);
	@Autowired
	AccountRepository accountRepository;
	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account findById(int id) {
		Account account = new Account();
		try{
			account = accountRepository.findById(id).get();
		}
		catch(NoSuchElementException e) {
			log.debug("Account does not exist.");
		}
		return account;
		
	}

	@Override
	public List<Account> findByEmail(String email) {
		return accountRepository.findByEmail(email);
	}

	@Override
	public void save(Account account) {
		accountRepository.save(account);
	}

	@Override
	public void update(int id, Account account) {
		accountRepository.save(account);
	}

	@Override
	public void delete(int id) {
		accountRepository.deleteById(id);
	}
	@Override
	public boolean login(String email, String password) {
		Account account = accountRepository.findByEmail(email).get(0);	//finds Account with matching email
		BCryptPasswordEncoder bCryptPasswordEncoder =
				  new BCryptPasswordEncoder(10, new SecureRandom());
		boolean validPassword = bCryptPasswordEncoder.matches(password, account.getPassword()); //Compares password with encrypted password in DB
		if(validPassword) {
			return true;	//Login Successful
		}
		else {
			return false;	//Login Failed
		}
	}
//	
	public void register(Account account) {
		//check if account already exists
		boolean accountDoesNotExist = accountRepository.findByEmail(account.getEmail()).isEmpty();
		
		//Encodes password for storage
		BCryptPasswordEncoder bCryptPasswordEncoder =
		  new BCryptPasswordEncoder(10, new SecureRandom());
		String encodedPassword = bCryptPasswordEncoder.encode(account.getPassword());
		//Create new account if valid
		if(accountDoesNotExist) {		
			account.setPassword(encodedPassword);			
			accountRepository.save(account);
		}
	}
}
