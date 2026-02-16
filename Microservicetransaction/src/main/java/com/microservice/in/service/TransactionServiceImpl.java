package com.microservice.in.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.in.entity.Transaction;
import com.microservice.in.transactionrepo.TransactionRepo;

@Service
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private  TransactionRepo repository;

	 @Override
	 public Transaction createTransaction(Transaction request) {
	  return repository.save(request);
	 }

	 @Override
	 public List<Transaction> getTransactionByAccount(Long accountId) {
	  return repository.findByAccountId(accountId);
	 }

	

}
