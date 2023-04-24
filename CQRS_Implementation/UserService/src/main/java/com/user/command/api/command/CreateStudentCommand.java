package com.user.command.api.command;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.user.entity.Address;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateStudentCommand {

	@TargetAggregateIdentifier
	private String stuId;
	private String name;
	private String collegeName;
	private List<Address> addresses = new ArrayList<>();

}
