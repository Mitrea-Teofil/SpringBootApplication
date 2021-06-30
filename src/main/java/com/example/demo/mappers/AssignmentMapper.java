package com.example.demo.mappers;

import com.example.demo.entities.Assignment;
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

    }


