package com.microservice.in.transactionrepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.in.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
	
	List<Transaction> findByAccountId(Long accountId);

}
