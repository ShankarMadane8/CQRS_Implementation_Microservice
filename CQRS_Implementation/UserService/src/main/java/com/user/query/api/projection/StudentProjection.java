package com.user.query.api.projection;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.command.api.model.StudentRestModel;
import com.user.entity.Address;
import com.user.entity.Student;
import com.user.feignclient.service.ContactService;
import com.user.query.api.queries.GetStudentsQuery;
import com.user.repository.StudentRepository;
import com.user.service.StudentService;

@Component
public class StudentProjection {
	
	@Autowired
	ContactService contactService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentRepository studentRepository;
	
	@QueryHandler
	public List<StudentRestModel> handle(GetStudentsQuery getStudentsQuery){
		
		
		//List<Student> students = studentService.getStudents();
		List<Student> students = studentRepository.findAll();
		
		
		List<StudentRestModel> list = students.stream().map(stu -> StudentRestModel
				.builder()
				.stuId(stu.getStuId())
				.name(stu.getName())
				.collegeName(stu.getCollegeName())
				.addresses(contactService.getAddressesByStuId(stu.getStuId()))
				.build()
				).collect(Collectors.toList());
		
		return list;
		
		
	}

}
