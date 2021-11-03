package com.revature.project2.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.project2.model.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	public List<Account> findByEmail(String email);

}
