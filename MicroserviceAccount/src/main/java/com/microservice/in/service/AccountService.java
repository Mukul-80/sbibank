package com.microservice.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.in.dto.AccountDetailsResponsedto;
import com.microservice.in.dto.Loandto;
import com.microservice.in.dto.Transcationdto;
import com.microservice.in.entity.Accountserviceentity;
import com.microservice.in.external.LoanClient;
import com.microservice.in.external.TransactionClient;
import com.microservice.in.repository.AccountserviceRepository;


@Service
public class AccountService {
	@Autowired
	private AccountserviceRepository accountserviceRepo;
	@Autowired
	 private LoanClient loanClient;
	 @Autowired
	 private TransactionClient transactionClient;
	 
	 public Accountserviceentity create(Accountserviceentity request) {
		 
		return accountserviceRepo.save(request);
	 }
	 
	public AccountDetailsResponsedto getAccountDetails(Long accountNumber) { 
	    	Accountserviceentity account=accountserviceRepo.findByAccountNumber(accountNumber).orElseThrow(()->new RuntimeException("Account not found"));
	    	Long accountId=account.getAccountNumber();
	    	

	        List<Loandto> loans = loanClient.getLoansByAccountId(accountId);
	        
	        List<Transcationdto> transactions =
	                transactionClient.getTransactions(accountId);
	        
	        AccountDetailsResponsedto response=new AccountDetailsResponsedto();
	        response.setAccountId(account.getId());
	        response.setName(account.getCustomerName());
	        response.setBalance(account.getBalance());
	        response.setTransactions(transactions);
	        response.setLoans(loans);

	        return response;
	    }

}
