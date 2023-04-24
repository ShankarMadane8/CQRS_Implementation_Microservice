package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.Student;
import com.user.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/student")
public class UserServiceController {

	@Autowired
	StudentService studentService;
 
	@Autowired
	LoadBalancerClient loadBalancerClient;
	
	
	 private static final Logger logger = LoggerFactory.getLogger(UserServiceController.class);

	 //int retryCount=1;
	 
	@GetMapping("/{stuId}")
	@CircuitBreaker(name = "addressStudentBreaker",fallbackMethod = "addressStudentFallback")
	//@Retry(name = "addressStudentRetry",fallbackMethod = "addressStudentFallback")
	//@RateLimiter(name = "addressStudentLimiter",fallbackMethod = "addressStudentFallback")
	public ResponseEntity<Student> getStudent(@PathVariable int stuId) {
		Student student = studentService.getStudent(stuId);
		//logger.info("==========================================");
		//logger.info("RetryCount: "+retryCount++);
	
		ServiceInstance serviceInstance = loadBalancerClient.choose("CONTACT-SERVICE");
		System.err.println("=============>"+serviceInstance.getUri().toString());
		
		return ResponseEntity.status(HttpStatus.OK).body(student);

	}
	
	
	//------------------------FallBackMethod-----------------------------
	public ResponseEntity<Student> addressStudentFallback(int stuId, Exception ex){
		//System.out.println("Fallback is executed because service is down: "+ex.getMessage());
		// logger.info("Fallback is executed because service is down: "+ex.getMessage());
		Student student=new Student();
		student.setName("dummyStudent");	
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	
	
	@GetMapping("/")
	public ResponseEntity<?> getStudents() {
		List<Student> list = studentService.getStudents();	
		return ResponseEntity.ok(list);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
    	Student student2 = studentService.saveStudent(student);
    	return ResponseEntity.status(HttpStatus.OK).body(student2);
	}
	

	
}
