package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Professor;
import com.example.demo.services.ProfessorService;

@RestController
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @RequestMapping("/professor")
    public List<Professor> getAll() {
        return professorService.getAll();
    }

    @RequestMapping("/professor/firstName")
    public List<String> getFirstNames() {
        return professorService.getFirstNames();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/professor")
    public ResponseEntity<Object> addProfessor(@Valid @RequestBody Professor professor) {
        boolean created = professorService.addProfessor(professor);
        if (created) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping("/professor/{Id}")
    public Professor getProfessorById(@PathVariable("Id") int id) {
        return professorService.getProfessorById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/professor/{Id}")
    public ResponseEntity<Object> deleteProfessorById(@PathVariable("Id") int id) {
        boolean deleted = professorService.deleteProfessorById(id);
        if (deleted){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/professor")
    public ResponseEntity<Object> updateProfessor(@Valid @RequestBody Professor professor) {
        boolean updated = professorService.updateProfessor(professor);
        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}