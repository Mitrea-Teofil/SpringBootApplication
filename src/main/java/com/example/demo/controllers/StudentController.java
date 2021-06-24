package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/student")
	public List<Student> getAll() {
		return studentService.getAll();
	}

	@RequestMapping("/student/firstName")
	public List<String> getFirstNames() {
		return studentService.getFirstNames();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/student")
	public ResponseEntity<Object> addStudent(@Valid @RequestBody Student student) {
		boolean created = studentService.addStudent(student);
		if (created) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping("/student/{Id}")
	public Student getStudentById(@PathVariable("Id") int id) {
		return studentService.getStudentById(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/student/{Id}")
	public ResponseEntity<Object> deleteStudentById(@PathVariable("Id") int id) {
		 boolean deleted = studentService.deleteStudentById(id);
		 if (deleted){
		 	return new ResponseEntity<>(HttpStatus.OK);
		 }
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/student")
	public ResponseEntity<Object> updateStudent(@Valid @RequestBody Student student) {
		boolean updated = studentService.updateStudent(student);
		if (updated) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}