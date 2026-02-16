package com.microservice.in.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDetailsResponsedto {
	private Long accountId;
	 private String name;
	 private Double balance;

	 private List<Transcationdto> transactions;
	 private List<Loandto> loans;

}
