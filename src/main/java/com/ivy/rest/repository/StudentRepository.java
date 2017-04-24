package com.ivy.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.ivy.rest.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
