package com.example.demo.repositories;

import com.example.demo.entities.Assignment;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mappers.AssignmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AssignmentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    AssignmentMapper assignmentMapper = new AssignmentMapper();

    public List<Assignment> getAll() {
        List<Assignment> result = jdbcTemplate.query("SELECT * FROM Assignment", assignmentMapper);
        return result;
    }

    public List<String> getNames() {
        List<String> result = jdbcTemplate.queryForList("SELECT name FROM Assignment", String.class);
        return result;
    }

    public boolean addAssignment(Assignment assignment) {
        int update = jdbcTemplate.update("INSERT INTO Assignment (name, description, creditsNumber, studentId, professorId) values (?, ?, ?, ?, ?)",
                assignment.getName(), assignment.getDescription(), assignment.getCreditsNumber(), assignment.getStudentId(), assignment.getProfessorId());
        return update > 0;
    }

    public Assignment getAssignmentById(int Id) {
        List<Assignment> assignments = jdbcTemplate.query(String.format("SELECT * FROM Assignment WHERE Id=%d", Id), assignmentMapper);
        if (assignments.isEmpty()) {
            throw new ResourceNotFoundException(String.format("assignment with Id=%d doesn't exist", Id));
        }
        return assignments.get(0);
    }

    public boolean deleteAssignmentById(Integer Id) {
        String sql = "DELETE FROM Assignment WHERE id = ?";
        Object[] args = new Object[]{Id};

        return jdbcTemplate.update(sql, args) == 1;
    }

    public boolean updateAssignment(Assignment assignment) {
        String sql = "UPDATE Assignment SET name = ?, description = ?, creditsNumber = ?, studentId = ?, professorId = ? WHERE id = ?";
        Object[] args = new Object[]{assignment.getName(), assignment.getDescription(), assignment.getCreditsNumber(), assignment.getStudentId(), assignment.getProfessorId(), assignment.getId()};

        return jdbcTemplate.update(sql, args) == 1;
    }
}