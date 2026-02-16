package com.microservice.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.in.entity.Transaction;
import com.microservice.in.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
     @Autowired
	 private TransactionService transactionService;

	 public TransactionController(TransactionService transactionService) {
	  this.transactionService = transactionService;
	 }

	 @PostMapping("/create")
	 public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction request) {

	  return ResponseEntity.ok(
	       transactionService.createTransaction(request));
	 }

	 @GetMapping("/account/{accountId}")
	 public ResponseEntity<List<Transaction>> getByAccount(@PathVariable Long accountId) {

	  return ResponseEntity.ok(transactionService.getTransactionByAccount(accountId));
	 }

}
