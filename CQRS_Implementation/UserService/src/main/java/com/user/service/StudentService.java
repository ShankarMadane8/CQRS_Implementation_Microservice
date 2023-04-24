package com.user.service;

import java.util.List;

import com.user.entity.Student;

public interface StudentService {
	
	 //Save Student
	 Student saveStudent(Student stu) ;
	 
	 
	 //get Single Student
	 Student getStudent(int stuId);
	 
	 //get all student
	 List<Student> getStudents();

}
