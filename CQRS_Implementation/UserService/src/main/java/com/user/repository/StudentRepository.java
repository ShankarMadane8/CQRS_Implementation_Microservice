package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	

}
