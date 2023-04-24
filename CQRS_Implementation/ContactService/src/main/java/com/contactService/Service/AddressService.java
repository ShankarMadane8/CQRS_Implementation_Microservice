package com.contactService.Service;

import java.util.List;

import com.contactService.entity.Address;

public interface AddressService {
	
	// get single address
	public Address getAddress(int addId);
	
	
	// get all address
	public List<Address> getAddresses();
	
	//get all address
	public List<Address> getAddressesByStuId(int stuId);
	
	
	
	// save Address
	public Address saveAddress(Address address);

}
