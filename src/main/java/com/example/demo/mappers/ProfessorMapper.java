package com.example.demo.mappers;

import com.example.demo.entities.Professor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorMapper implements RowMapper<Professor> {

    @Override
    public Professor mapRow(ResultSet rs, int rownumber) throws SQLException {
        Professor professor = new Professor();
        professor.setId(rs.getInt(1));
        professor.setLastName(rs.getString(2));
        professor.setFirstName(rs.getString(3));
        professor.setSubjectProfessor((rs.getString(4)));
        professor.setEmail(rs.getString(5));
        professor.setNrOfTeachingHours(rs.getInt(6));

        return professor;
    }
}

