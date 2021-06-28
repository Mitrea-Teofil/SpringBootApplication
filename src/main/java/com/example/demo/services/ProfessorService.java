package com.example.demo.services;

import com.example.demo.entities.Professor;
import com.example.demo.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public List<Professor> getAll() {
        return professorRepository.getAll();
    }

    public List<String> getFirstNames() {
        return professorRepository.getfirstNames();
    }

    public boolean addProfessor(Professor professor) {

        return professorRepository.addProfessor(professor);

    }
    public Professor getProfessorById (int Id){
        return professorRepository.getProfessorById(Id);
    }

    public boolean deleteProfessorById (int Id){
        return professorRepository.deleteProfessorById(Id);
    }

    public boolean updateProfessor(Professor professor) {
        return professorRepository.updateProfessor(professor);
    }


}
