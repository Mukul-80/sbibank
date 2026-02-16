package com.microservice.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.in.entity.Accountserviceentity;
import com.microservice.in.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountServiceController {
	@Autowired
	private AccountService accountService ;
	
	@PostMapping("/create")
	public ResponseEntity<Accountserviceentity> savingAccount(@RequestBody Accountserviceentity request) {
		System.out.println("Customer name " +request.getCustomerName());
		return  ResponseEntity.ok(accountService.create(request));
	}
	
	@GetMapping("/{accountNumber}")
    public ResponseEntity<?> getDetails(@PathVariable Long accountNumber) {

        return ResponseEntity.ok(
                accountService.getAccountDetails(accountNumber));
    }
	

}
