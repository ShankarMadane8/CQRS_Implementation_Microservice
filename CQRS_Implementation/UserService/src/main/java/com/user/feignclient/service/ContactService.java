package com.user.feignclient.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.entity.Address;


@Service
@FeignClient(name = "CONTACT-SERVICE") 
public interface ContactService {
	
	//get single Address
	@GetMapping("/address/{addId}")
	Address getAddress(@PathVariable int addId);
	
	// get addresses by student Id
	@GetMapping("/address/student/{stuId}")
	List<Address> getAddressesByStuId(@PathVariable int stuId);
}
