package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAll() {
		return studentRepository.getAll();
	}

	public List<String> getFirstNames() {
		return studentRepository.getfirstNames();
	}

	public boolean addStudent(Student student) {

		return studentRepository.add(student);

	}
	public Student getStudentById (int Id){
		return studentRepository.getStudentById(Id);
	}

}
