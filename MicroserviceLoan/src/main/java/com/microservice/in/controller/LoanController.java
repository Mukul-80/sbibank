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
import com.microservice.in.entity.Loan;
import com.microservice.in.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
  @Autowired
  private LoanService loanService;
   
  /*public LoanController(LoanService loanService) {
	  this.loanService=loanService;
  }*/
   @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Loan>> getLoans(@PathVariable Long accountId) {
          return ResponseEntity.ok(loanService.getLoansByAccountId(accountId));
	  }
  
    @PostMapping("/create")
     public Loan createloan(@RequestBody Loan loan) {
	   return loanService.saveLoan(loan);
    }
}
