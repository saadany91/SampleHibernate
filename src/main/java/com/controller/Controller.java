package com.controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.models.Gender;
//import com.models.Address;
import com.models.Student;
import com.service.ServiceI;


@RestController
@RequestMapping("students")
public class Controller<T> {
	
	@Autowired
	ServiceI service;
		
	
	@RequestMapping(method= RequestMethod.POST )
	public  ResponseEntity<String> add(@RequestBody Student s) {
		
	
		
		service.add(s);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<T> getStudents(){
		
		T body;
		HttpStatus status;
		
		body=(T) service.getAll();
		status = HttpStatus.OK;
				
		return new ResponseEntity<T>(body,status);
		
	}
	
	
	
	
}
