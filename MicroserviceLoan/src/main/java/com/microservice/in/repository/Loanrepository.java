package com.microservice.in.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.in.entity.Loan;

@Repository
public interface Loanrepository extends JpaRepository<Loan, Long>{
	
	List<Loan> findByAccountId(Long accountId);

}
