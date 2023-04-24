package com.user.command.api.model;

import java.util.ArrayList;
import java.util.List;

import com.user.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRestModel {

	private int stuId;
	private String name;
	private String collegeName;
	 List<Address> addresses = new ArrayList<>();

}
