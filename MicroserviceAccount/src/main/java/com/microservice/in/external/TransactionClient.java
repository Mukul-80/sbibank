package com.microservice.in.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.in.dto.Transcationdto;

@FeignClient(name="transaction-service",url="http://localhost:9094")
public interface TransactionClient {
	@GetMapping("/transactions/account/{accountId}")
    List<Transcationdto> getTransactions(@PathVariable Long accountId);
}

