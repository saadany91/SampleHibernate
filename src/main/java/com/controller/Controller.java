package com.controller;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
	
	@RequestMapping("/")
	public  ResponseEntity<String> add() {
		
	
		Student s1 = new Student();
		s1.setLocation("florida");
		s1.setMarks(3.0f);
		s1.setRank(22);
		s1.setSname("mohamed");
		s1.setGender(Gender.MALE);
		s1.setGenderChar(Gender.MALE.getType());
		
		service.add(s1);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@RequestMapping("/get")
	public ResponseEntity<T> getStudents(){
		
		T body;
		HttpStatus status;
		
		body=(T) service.getAll();
		status = HttpStatus.OK;
				
		return new ResponseEntity<T>(body,status);
		
	}
	
	
	
	
}
