package com.example.demo.repositories;

import com.example.demo.entities.Professor;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mappers.ProfessorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfessorRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    ProfessorMapper professorMapper = new ProfessorMapper();

    public List<Professor> getAll() {
        List<Professor> result = jdbcTemplate.query("SELECT * FROM Professor", professorMapper);
        return result;
    }

    public List<String> getfirstNames() {
        List<String> result = jdbcTemplate.queryForList("SELECT firstName FROM Professor", String.class);
        return result;
    }

    public boolean addProfessor(Professor professor) {
        int update = jdbcTemplate.update("INSERT INTO Professor (lastName, firstName, subjectProfessor, email, nrOfTeachingHours) values (?, ?, ?, ?, ?)",
                professor.getLastName(), professor.getFirstName(), professor.getSubjectProfessor(), professor.getEmail(), professor.getNrOfTeachingHours());
        return update > 0;
    }

    public Professor getProfessorById(int Id) {
        List<Professor> professors = jdbcTemplate.query(String.format("SELECT * FROM Professor WHERE Id=%d", Id), professorMapper);
        if (professors.isEmpty()) {
            throw new ResourceNotFoundException(String.format("professor with Id=%d doesn't exist", Id));
        }
        return professors.get(0);
    }

    public boolean deleteProfessorById(Integer Id) {
        String sql = "DELETE FROM Professor WHERE id = ?";
        Object[] args = new Object[]{Id};

        return jdbcTemplate.update(sql, args) == 1;
    }

    public boolean updateProfessor(Professor professor) {
        String sql = "UPDATE Professor SET lastName = ?, firstName = ?, subjectProfessor = ?, email = ?, nrOfTeachingHours = ? WHERE id = ?";
        Object[] args = new Object[]{professor.getLastName(), professor.getFirstName(), professor.getSubjectProfessor(), professor.getEmail(), professor.getNrOfTeachingHours(), professor.getId()};

        return jdbcTemplate.update(sql, args) == 1;
    }
}