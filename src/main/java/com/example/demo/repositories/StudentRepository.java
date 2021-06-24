package com.example.demo.repositories;

import com.example.demo.entities.Student;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	StudentMapper studentMapper = new StudentMapper();

	public List<Student> getAll() {
		List<Student> result = jdbcTemplate.query("SELECT * FROM Student", studentMapper);
		return result;
	}

	public List<String> getfirstNames() {
		List<String> result = jdbcTemplate.queryForList("SELECT firstName FROM Student", String.class);
		return result;
	}

	public boolean add(Student student) {
		int update = jdbcTemplate.update("INSERT INTO Student (lastName, firstName, email, age) values (?, ?, ?, ?)",
				student.getLastName(), student.getFirstName(), student.getEmail(), student.getAge());
		return update > 0;
	}

	public Student getStudentById(int Id) {
		List<Student> students = jdbcTemplate.query(String.format("SELECT * FROM Student WHERE Id=%d", Id), studentMapper);
		if (students.isEmpty()) {
			throw new ResourceNotFoundException(String.format("student with Id=%d doesnt exist", Id));
		}
		return students.get(0);
	}

	public boolean deleteStudentById(Integer Id) {
		String sql = "DELETE FROM Student WHERE id = ?";
		Object[] args = new Object[]{Id};

		return jdbcTemplate.update(sql, args) == 1;
	}

	public boolean updateStudent(Student student) {
		String sql = "UPDATE Student SET lastName = ?, firstName = ?, email = ?, age = ? WHERE id = ?";
		Object[] args = new Object[]{student.getLastName(), student.getFirstName(), student.getEmail(), student.getAge(), student.getId()};

		return jdbcTemplate.update(sql, args) == 1;
	}
}