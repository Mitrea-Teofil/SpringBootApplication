package com.example.demo.mappers;

import com.example.demo.entities.Assignment;
import com.example.demo.entities.RAssignment;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignmentMapper implements RowMapper<Assignment> {

        @Override
        public Assignment mapRow(ResultSet rs, int rownumber) throws SQLException{

            Assignment assignment = new Assignment();
            assignment.setId(rs.getInt(1));
            assignment.setName(rs.getString(2));
            assignment.setDescription(rs.getString(3));
            assignment.setCreditsNumber(rs.getInt(4));
            assignment.setStudentId(rs.getInt(5));
            assignment.setProfessorId(rs.getInt(6));

            return assignment;
        }

    public static void toRestModel(Assignment assignment, RAssignment rAssignment) {

            rAssignment.setCreditsNumber(assignment.getCreditsNumber());
            rAssignment.setDescription(assignment.getDescription());
            rAssignment.setName(assignment.getName());
            rAssignment.setId(assignment.getId());
    }

    public static void toServerModel(RAssignment rAssignment, Assignment assignment) {

        assignment.setCreditsNumber(rAssignment.getCreditsNumber());
        assignment.setDescription(rAssignment.getDescription());
        assignment.setName(rAssignment.getName());
        assignment.setId(rAssignment.getId());
        if(rAssignment.getStudent() != null ){
                assignment.setStudentId(rAssignment.getStudent().getId());
        }
        else {
            throw new IllegalArgumentException("Student must not be null!");
        }


        if(rAssignment.getProfessor() != null){
            assignment.setProfessorId(rAssignment.getProfessor().getId());
        }
        else {
            throw new IllegalArgumentException("Professor must nbe not null");
        }
    }
}


