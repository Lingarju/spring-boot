package com.registration.StudentRegistration.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
	
	/**
	 * we are autowiring jdbc template
	 * using the properties we have configured in apllication.properties spring
	 * automatically detects and creates jdbc template object using the configuration
	 */
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * returns list students
	 * @return studentList
	 */
	public List<String> getAllStudents() {
		
		List<String> studentList = new ArrayList<>();
		studentList.addAll(jdbcTemplate.queryForList("select first_name from student;", String.class));
		return studentList;
	}
	
	/**
	 * to insert a student record into the database
	 * @return success massage
	 */
	public String registerStudent() {   
        jdbcTemplate.execute("insert into student(first_name, last_name, address, email) values('Raju3', 'Darra', 'Venkatapuram', \'dlraju3@gmail.com')");  
        return"data inserted Successfully";  
    }  
	

}
