package com.microservice.in.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.microservice.in.entity.Loan;
import com.microservice.in.repository.Loanrepository;

@Service
public class LoanService {
	@Autowired
	private Loanrepository loanRepository;
	
	public List<Loan> getLoansByAccountId(Long accountId) {
	    return loanRepository.findByAccountId(accountId);
	}

    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }
    
}
