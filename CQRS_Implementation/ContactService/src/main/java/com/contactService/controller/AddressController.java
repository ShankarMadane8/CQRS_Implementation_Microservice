package com.contactService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactService.Service.AddressService;
import com.contactService.entity.Address;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("/{addId}")
	public ResponseEntity<Address> getSAddress(@PathVariable int addId) {
		Address address = addressService.getAddress(addId);
		return ResponseEntity.ok(address);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<?> getSAddresses() {
		 List<Address> list = addressService.getAddresses();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/student/{stuId}")
	public ResponseEntity<?> getSAddressesByStuId(@PathVariable int stuId) {
		 List<Address> list = addressService.getAddressesByStuId(stuId);
		// System.err.println("8182");
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address){
		Address address2 = addressService.saveAddress(address);
		return ResponseEntity.ok(address2);
	}
	
	
	

}
