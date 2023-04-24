package com.user.command.api.aggregate;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.user.command.api.command.CreateStudentCommand;
import com.user.command.api.events.StudentCreateEvent;
import com.user.entity.Address;

import lombok.Data;

@Aggregate
@Data
public class StudentAggregate {
	
	@AggregateIdentifier
	private String stuId;
	
	private String name;
	private String collegeName;
	private List<Address> addresses = new ArrayList<>();
	
	
	public StudentAggregate() {
		
	}
	
	@CommandHandler
	public StudentAggregate(CreateStudentCommand createStudentCommand) {
		// validate Student Data
		
		StudentCreateEvent studentCreateEvent =
				StudentCreateEvent.builder().build();
	
		
		BeanUtils.copyProperties(createStudentCommand, studentCreateEvent);
		
			AggregateLifecycle.apply(studentCreateEvent);
		
	}
	
	@EventSourcingHandler
	public void on(StudentCreateEvent studentCreateEvent) {
		this.stuId=studentCreateEvent.getStuId();
		this.name=studentCreateEvent.getName();
		this.collegeName=studentCreateEvent.getCollegeName();
		this.addresses=studentCreateEvent.getAddresses();
		
	}
	
	
	

}
