package com.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addId;
	private int stuId;
	private int mobileNo;
	private String city;
	


	
	

//	public int getId() {
//		return addId;
//	}
//
//	public void setId(int id) {
//		this.addId = id;
//	}
//
//	public int getStuId() {
//		return stuId;
//	}
//
//	public void setStuId(int stuId) {
//		this.stuId = stuId;
//	}
//
//	public int getMobileNo() {
//		return mobileNo;
//	}
//
//	public void setMobileNo(int mobileNo) {
//		this.mobileNo = mobileNo;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}

}
