package com.example.demo.services;

import com.example.demo.entities.Assignment;
import com.example.demo.entities.Professor;
import com.example.demo.entities.RAssignment;
import com.example.demo.entities.Student;
import com.example.demo.mappers.AssignmentMapper;
import com.example.demo.repositories.AssignmentRepository;
import com.example.demo.repositories.ProfessorRepository;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentService {
    @Autowired
    AssignmentRepository assignmentRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProfessorRepository professorRepository;

    public List<RAssignment> getAll(){
        List<Assignment> assignments = assignmentRepository.getAll();
        return assignments.stream().map(this::toRestModel).collect(Collectors.toList());
    }

    public List<String> getNames(){
        return assignmentRepository.getNames();
    }

    public boolean addAssignment(RAssignment rAssignment){

        Assignment assignment = new Assignment();
        AssignmentMapper.toServerModel(rAssignment, assignment);
        return assignmentRepository.addAssignment(assignment);

    }

    public RAssignment getAssignmentById(int Id){
        Assignment assignment = assignmentRepository.getAssignmentById(Id);
        return toRestModel(assignment);
    }

    private RAssignment toRestModel(Assignment assignment) {

        RAssignment rAssignment = new RAssignment();
        AssignmentMapper.toRestModel(assignment, rAssignment);

        Student studentById = studentRepository.getStudentById(assignment.getStudentId());
        Professor professorById = professorRepository.getProfessorById((assignment.getProfessorId()));

        rAssignment.setStudent(studentById);
        rAssignment.setProfessor(professorById);

        return rAssignment;

    }

    public boolean deleteAssignmentById(int Id){
        return assignmentRepository.deleteAssignmentById(Id);
    }

    public boolean updateAssignment(RAssignment rAssignment){

        Assignment assignment = new Assignment();
        AssignmentMapper.toServerModel(rAssignment, assignment);
        return assignmentRepository.updateAssignment(assignment);
    }
}
