package com.microservice.in.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Loan {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(unique = true)
	 private String loanNumber;
     private Long accountId;
	 private String loanType;
	 private Double loanAmount;
	 private Double interestRate;
	 @Column(nullable=false)
	 private Integer tenureMonths;
	 private Double emiAmount;
	 private String status; // APPROVED, RUNNING, CLOSED
	 @Column(nullable=false)
	 private LocalDate startDate;
	 @Column(nullable=false)
	 private LocalDate endDate;
	 
	 @PrePersist
	 public void onCreate() {
		 this.startDate=LocalDate.now();
		 this.endDate=this.startDate.plusMonths(this.tenureMonths);
	 }

}
