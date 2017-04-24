package com.ivy.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ivy.rest.entity.Student;
import com.ivy.rest.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService stuService;
	
	@RequestMapping(method=RequestMethod.POST, value="/students")
	public void addStudents(@RequestBody Student student) {
		stuService.addStudent(student);
	}
	
	@RequestMapping("/students")
	public List<Student> getAllStudents() {
		return stuService.getAllStudents();
	}

}
