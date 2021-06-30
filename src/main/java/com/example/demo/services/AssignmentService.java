package com.example.demo.services;

import com.example.demo.entities.Assignment;
import com.example.demo.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    AssignmentRepository assignmentRepository;

    public List<Assignment> getAll(){
        return assignmentRepository.getAll();
    }

    public List<String> getNames(){
        return assignmentRepository.getNames();
    }

    public boolean addAssignment(Assignment assignment){
        return assignmentRepository.addAssignment(assignment);
    }

    public Assignment getAssignmentById(int Id){
        return assignmentRepository.getAssignmentById(Id);
    }

    public boolean deleteAssignmentById(int Id){
        return assignmentRepository.deleteAssignmentById(Id);
    }

    public boolean updateAssignment(Assignment assignment){
        return assignmentRepository.updateAssignment(assignment);
    }
}
