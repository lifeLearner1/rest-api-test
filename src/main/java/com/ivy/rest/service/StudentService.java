package com.ivy.rest.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivy.rest.entity.Student;
import com.ivy.rest.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository stuRep;
	
	public List<Student> getAllStudents() {
		List<Student> lists = new ArrayList<>();
		stuRep.findAll().forEach(lists::add);
		return lists;
	}

	public void addStudent(Student student) {
		stuRep.save(student);
		
	}

}
