package com.example.demo.errors;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
	int status;
	String message;
	String path;
	Map<String, String> validationErrors;

	public ApiError(int status, String message, String path) {
		super();
		this.status = status;
		this.message = message;
		this.path = path;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(Map<String, String> validationErrors) {
		this.validationErrors = validationErrors;
	}

}
