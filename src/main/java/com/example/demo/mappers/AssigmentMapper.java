package com.example.demo.mappers;

import com.example.demo.entities.Assigment;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssigmentMapper implements RowMapper<Assigment> {

        @Override
        public Assigment mapRow(ResultSet rs, int rownumber) throws SQLException{

            Assigment assigment = new Assigment();
            assigment.setId(rs.getInt(1));
            assigment.setName(rs.getString(2));
            assigment.setDescription(rs.getString(3));
            assigment.setCreditsNumber(rs.getInt(4));
            assigment.setStudentId(rs.getInt(5));
            assigment.setProfessorId(rs.getInt(6));

            return assigment;
        }

    }


