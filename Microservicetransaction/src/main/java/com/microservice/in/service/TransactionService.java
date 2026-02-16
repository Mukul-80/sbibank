package com.microservice.in.service;

import java.util.List;

import com.microservice.in.entity.Transaction;

public interface TransactionService {
	
	Transaction createTransaction(Transaction request);

	 List<Transaction> getTransactionByAccount(Long accountId);

}
