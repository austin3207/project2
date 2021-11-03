package com.revature.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
