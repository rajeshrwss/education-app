package com.example.demo.binding;

import jakarta.validation.constraints.NotNull;

public class ForgotPwdForm {
	   
	@NotNull(message = "Email cannot be null")
	private String emailId;
	
	private String newPassword;
	
	private String confirmPassword;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
