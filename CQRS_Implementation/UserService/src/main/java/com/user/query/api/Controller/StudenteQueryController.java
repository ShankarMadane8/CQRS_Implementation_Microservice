package com.user.query.api.Controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.bouncycastle.asn1.cmc.GetCert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.command.api.model.StudentRestModel;
import com.user.query.api.queries.GetStudentsQuery;

@RestController
@RequestMapping("/studentQueryApi")
public class StudenteQueryController {
	
	@Autowired
	QueryGateway queryGateway;
	
	
	@GetMapping("/all")
	public List<StudentRestModel> getAllStudents(){
		GetStudentsQuery getStudentsQuery =new GetStudentsQuery();
		
	List<StudentRestModel> list=
			queryGateway
			.query(getStudentsQuery, ResponseTypes.multipleInstancesOf(StudentRestModel.class))
			.join();
		
		return list;
	}	
	
	

}
