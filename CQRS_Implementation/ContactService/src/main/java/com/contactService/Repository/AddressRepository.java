package com.contactService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contactService.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	  List<Address> findByStuId( int stuId );

}
