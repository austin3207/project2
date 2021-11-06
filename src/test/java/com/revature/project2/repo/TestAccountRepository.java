package com.revature.project2.repo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.revature.project2.model.Account;

public class TestAccountRepository {
	private int accountID = 1;

	private List<Account> accountRepository = new CopyOnWriteArrayList<Account>();

	public List<Account> findAll() {
		return accountRepository;
	}

	public Account findById(int id) {
		for (Account account : accountRepository) {
			if (account.getId() == id) {
				return account;
			}
		}
		return null;
	}

	public Account findByEmail(String email) {
		for (Account account : accountRepository) {
			if (account.getEmail().equals(email)) {
				return account;
			}
		}
		return null;
	}

	public void save(Account account) {
		account.setId(accountID);
		accountRepository.add(account);
		accountID++;
	}

	public void update(int id, Account account) {
		for (Account accountIteration : accountRepository) {
			if (accountIteration.getId() == id) {
				accountRepository.add(account);
			}
		}
	}

	public void delete(int id) {
		for (Account account : accountRepository) {
			if (account.getId() == id) {
				accountRepository.remove(account);
			}
		}
	}
}
