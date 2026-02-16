package com.microservice.in.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.in.dto.Loandto;

@FeignClient(name="loan-service",url="http://localhost:9093")
public interface LoanClient {
	@GetMapping("/loans/account/{accountId}")
   List<Loandto> getLoansByAccountId(@PathVariable Long accountId);
}


