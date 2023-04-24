package com.contactService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactService.Repository.AddressRepository;
import com.contactService.entity.Address;

@Service
public class AddressServiceImpl implements AddressService{
	

	@Autowired
	AddressRepository addressRepository;

	@Override
	public Address getAddress(int addId) {
		Optional<Address> optional = addressRepository.findById(addId);
		return optional.get();
	}

	@Override
	public List<Address> getAddresses() {
		List<Address> list = addressRepository.findAll();
		return list;
	}

	
	@Override
	public Address saveAddress(Address address) {
		Address address2 = addressRepository.save(address);
		
		return address2;
	}

	@Override
	public List<Address> getAddressesByStuId(int stuId) {
		List<Address> list = addressRepository.findByStuId(stuId);
		return list;
	}

}
