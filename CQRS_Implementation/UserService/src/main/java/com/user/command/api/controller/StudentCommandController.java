package com.user.command.api.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.command.api.command.CreateStudentCommand;
import com.user.command.api.model.StudentRestModel;

@RestController
@RequestMapping("/studentApi")
public class StudentCommandController {
	
	private CommandGateway commandGateway;
	
	@Autowired
	public StudentCommandController(CommandGateway commandGateway) {
		super();
		this.commandGateway = commandGateway;
	}

	
	@PostMapping("/add")
	public String createStudent(@RequestBody StudentRestModel studentRestModel) {
		String id=UUID.randomUUID().toString();
		CreateStudentCommand createStudentCommand=
				CreateStudentCommand
				.builder()
				.stuId(id)
				.name(studentRestModel.getName())
				.collegeName(studentRestModel.getCollegeName())
				.addresses(studentRestModel.getAddresses()).build();
		//commandGateway.send(createStudentCommand);
		commandGateway.sendAndWait(createStudentCommand);
		
		return "Student Create id: "+id;	
	}

	
}

//1.first create Model/Dto

//2.create Controller Class and commandGatey object call sendandWait method
//parameter any commandCreate like createStudentCommand

//3.CreateStudentCommand class and define all parameter of entity class 
//and one own parameter is added like orderId,stuId but this type is String(Unique)

//4.create StudentAggreagte class and apply annotation @Aggregate
//and declare similarly data fields of CreateStudentCommand Class and apply annotation @AggregateIdetenfier
//Create Default constructor and parameter(CreateStudentCommand) constructor and apply annotation @commandHandler
//method body create the object of StudentCreateEvent class then AggregetLifeCycle.apply(StudentCreateEvent)
//new method on(StudentCreateEvent event) and apply annotation @eventSourcingHandelr method parameter pass StudentCreatedEvent  current class data field

//5.Create StudentEventHandler class and apply @component annotation
// in this class create one new method on(StudentCreateEvent event) and apply annotation @EventHandeler


