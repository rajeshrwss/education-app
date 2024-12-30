package com.example.demo.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SignUpForm {
	
	private String studentName;

	@NotNull(message = "Email cannot be null")
    @Email(message = "Invalid email format")
    @Size(max = 255, message = "Email size should not exceed 255 characters")
	private String emailId;

	private String password;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
