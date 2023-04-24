package com.user.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Address;
import com.user.entity.Student;
import com.user.feignclient.service.ContactService;
import com.user.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired 
	ContactService contactService;
	
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Student saveStudent(Student stu) {
		Student student = studentRepository.save(stu);
		
		return student;
	}

	@Override
	public Student getStudent(int stuId) {
		 Student student = studentRepository.findById(stuId).get();	
		//List<Address> list = restTemplate.getForObject("http://localhost:8182/address/student/"+student.getStuId(), List.class);
		//List<Address> list = restTemplate.getForObject("http://CONTACT-SERVICE/address/student/"+student.getStuId(), List.class); // loadbalanced required
		List<Address> list = contactService.getAddressesByStuId(stuId);
		student.setAddresses(list);
		return student;
	}

	@Override
	public List<Student> getStudents() {
		List<Student> list = studentRepository.findAll();
		
		List<Student> list2 = list.stream().map((Function<? super Student, ? extends Student>) student->{
			//List<Address> list1 = restTemplate.getForObject("http://localhost:8182/address/student/"+student.getStuId(), List.class);
			
			List<Address> list1 = restTemplate.getForObject("http://CONTACT-SERVICE/address/student/"+student.getStuId(), List.class);
			//List<Address> list1 = contactService.getAddressesByStuId(student.getStuId());
			student.setAddresses(list1);
			return student;
		}).collect(Collectors.toList());
		
		return list2;
	}

}
