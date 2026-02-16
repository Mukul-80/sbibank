package com.microservice.in.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.in.entity.Accountserviceentity;

@Repository
public interface AccountserviceRepository extends JpaRepository<Accountserviceentity, Long>{
	
	Optional<Accountserviceentity>findByAccountNumber(Long AccountNumber);

}
