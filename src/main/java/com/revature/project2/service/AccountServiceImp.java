package com.revature.project2.service;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.project2.model.Account;
import com.revature.project2.repo.AccountRepository;
@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id).get();
	}

	@Override
	public List<Account> findByEmail(String email) {
		// TODO Auto-generated method stub
		return accountRepository.findByEmail(email);
	}

	@Override
	public void save(Account account) {
		// TODO Auto-generated method stub
		accountRepository.save(account);
	}

	@Override
	public void update(int id, Account account) {
		// TODO Auto-generated method stub
		accountRepository.save(account);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(id);
	}
	@Override
	public boolean login(String email, String password) {
		Account account = accountRepository.findByEmail(email).get(0);
		BCryptPasswordEncoder bCryptPasswordEncoder =
				  new BCryptPasswordEncoder(10, new SecureRandom());
		boolean validPassword = bCryptPasswordEncoder.matches(password, account.getPassword());
		if(validPassword) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public void register(String email, String password, String firstName, String lastName) {
		//check if account already exists
		boolean accountDoesNotExist = accountRepository.findByEmail(email).isEmpty();
		//Create new account
		//Encodes password for storage
		BCryptPasswordEncoder bCryptPasswordEncoder =
		  new BCryptPasswordEncoder(10, new SecureRandom());
		String encodedPassword = bCryptPasswordEncoder.encode(password);
		 
		if(accountDoesNotExist) {
			Account account = new Account();
			account.setEmail(email);
			account.setPassword(encodedPassword);
			account.setFirstName(firstName);
			account.setLastName(lastName);
			accountRepository.save(account);
		}
		else {
			
		}
	}

}
