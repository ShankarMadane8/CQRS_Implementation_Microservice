package com.user.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int stuId;
	
	
	
    private String name;
    private String collegeName;
    
    @OneToMany
    private List<Address> addresses=new ArrayList<>();

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getCollegeName() {
//		return collegeName;
//	}
//
//	public void setCollegeName(String collegeName) {
//		this.collegeName = collegeName;
//	}
//
//	public List<Address> getAddresses() {
//		return addresses;
//	}
//
//	public void setAddresses(List<Address> addresses) {
//		this.addresses = addresses;
//	}    
    

}
