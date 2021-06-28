package com.example.demo.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Professor {

    private int id;
    @NotNull
    private String lastName;
    @NotNull
    @Size(min = 2)
    private String firstName;
    @NotNull
    private String subjectProfessor;
    @NotNull()
    @Email
    private String email;
    @NotNull
    private int nrOfTeachingHours;

    public Professor() {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.subjectProfessor = subjectProfessor;
        this.email = email;
        this.nrOfTeachingHours = nrOfTeachingHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSubjectProfessor() {
        return subjectProfessor;
    }

    public void setSubjectProfessor(String subjectProfessor) {
        this.subjectProfessor = subjectProfessor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNrOfTeachingHours() {
        return nrOfTeachingHours;
    }

    public void setNrOfTeachingHours(int nrOfTeachingHours) {
        this.nrOfTeachingHours = nrOfTeachingHours;
    }

}
