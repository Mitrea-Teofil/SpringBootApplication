package com.example.demo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.entities.Student;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rownumber) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt(1));
		student.setLastName(rs.getString(2));
		student.setFirstName(rs.getString(3));
		student.setEmail(rs.getString(4));
		student.setAge(rs.getInt(5));

		return student;
	}

}
