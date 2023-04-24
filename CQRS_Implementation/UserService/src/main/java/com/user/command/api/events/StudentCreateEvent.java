package com.user.command.api.events;

import java.util.ArrayList;
import java.util.List;

import com.user.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateEvent {
	
	private String stuId;
	private String name;
	private String collegeName;
	private List<Address> addresses = new ArrayList<>();

}
