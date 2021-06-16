package com.example.demo.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {

	private int id;
	@NotNull
	private String lastName;
	@NotNull
	@Size(min = 2)
	private String firstName;
	@NotNull()
	@Email
	private String email;
	@NotNull
	private int age;

	public Student(int id, String lastName, String firstName, String email, int age) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.age = age;
	}

	public Student() {
		// TODO Auto-generated constructor stub
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ ", age=" + age + "]";
	}

}
