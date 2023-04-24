package com.user.command.api.events;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.command.api.command.CreateStudentCommand;
import com.user.entity.Student;
import com.user.service.StudentService;

@Component
public class StudentEventHandler {

	@Autowired
	StudentService studentService;

	@EventHandler
	public void on(StudentCreateEvent studentCreateEvent) {
		Student student = Student.builder().build();
		BeanUtils.copyProperties(studentCreateEvent, student);

		studentService.saveStudent(student);
		System.err.println("Student Event Handle Working.....");
	}

	

}
