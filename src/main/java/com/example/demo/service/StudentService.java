package com.example.demo.service;

import com.example.demo.binding.SignUpForm;
import com.example.demo.entity.StudentEntity;

public interface StudentService {	

	public String registerUser(SignUpForm signupForm);

	public boolean authenticate(String emailId, String password);

	public String resetPwd(String emailId);
	
	public String resetPwd(String emailId,String newPassword,String oldPassword);

}
