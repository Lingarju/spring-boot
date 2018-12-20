package com.registration.StudentRegistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.StudentRegistration.repository.StudentRepository;

// make this as controller

@RestController
@RequestMapping(path="/student")
public class StudentController {
	
	// autowiring student repository
	@Autowired
	StudentRepository studentRepository;
	
	//to test our service is up and running
	@GetMapping
	public String check() {
		return "Welcome to Spring boot application";
	}
	
	/** this method return list of students
	 * @return studentList
	 */
	@GetMapping(path="/getstudents")
	public List<String> getAllStudents() {
		return studentRepository.getAllStudents();
	}
	
	/**
	 * insert a student record into to database
	 * @return success message
	 */   
    @RequestMapping("/insert") 
	public String registerStudent() {   
	        return studentRepository.registerStudent();
	    }  
		
		
	}
