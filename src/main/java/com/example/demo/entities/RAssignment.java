package com.example.demo.entities;

import javax.validation.constraints.NotNull;

public class RAssignment {

    private int id;
    private String name;
    private String description;
    @NotNull
    private int creditsNumber;
    @NotNull
    private Student student;
    @NotNull
    private Professor professor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreditsNumber() {
        return creditsNumber;
    }

    public void setCreditsNumber(int creditsNumber) {
        this.creditsNumber = creditsNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
