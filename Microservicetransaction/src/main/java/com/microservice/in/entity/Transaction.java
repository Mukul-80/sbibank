package com.microservice.in.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @Column(nullable = false)
	 private Long accountId;   // From Account Service

	 @Column(nullable = false)
	 private Double amount;

	 @Column(nullable = false)
	 private String type; // CREDIT / DEBIT

	 private String status; // SUCCESS / FAILED

	 private LocalDate transactionDate;

	 private String referenceNumber;
	 
	 @PrePersist
	 public void onCreate() {
		 this.transactionDate=LocalDate.now();
	 }

}
