package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Assignment;
import com.example.demo.services.AssignmentService;

@RestController
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    @RequestMapping("/assignment")
    public List<Assignment> getAll() {
        return assignmentService.getAll();
    }

    @RequestMapping("/assignment/name")
    public List<String> getNames() {
        return assignmentService.getNames();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/assignment")
    public ResponseEntity<Object> addAssignment(@Valid @RequestBody Assignment assignment) {
        boolean created = assignmentService.addAssignment(assignment);
        if (created) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping("/assignment/{Id}")
    public Assignment getAssignmentById(@PathVariable("Id") int id) {
        return assignmentService.getAssignmentById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/assignment/{Id}")
    public ResponseEntity<Object> deleteAssignmentById(@PathVariable("Id") int id) {
        boolean deleted = assignmentService.deleteAssignmentById(id);
        if (deleted){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/assignment")
    public ResponseEntity<Object> updateAssignment(@Valid @RequestBody Assignment assignment) {
        boolean updated = assignmentService.updateAssignment(assignment);
        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}