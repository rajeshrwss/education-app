package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.binding.SignUpForm;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.StudentService;
import com.example.demo.util.EmailUtil;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private EmailUtil emailutil;
	
	@Override
	public String registerUser(SignUpForm signupForm) {
		
		List<StudentEntity> existingStudent = studentRepo.findByEmailId(signupForm.getEmailId());
        if (!existingStudent.isEmpty()) {
            return "Email already in use!";
        }
		
		StudentEntity entity = new StudentEntity();
		entity.setStudentName(signupForm.getStudentName());
		entity.setEmailId(signupForm.getEmailId());
		entity.setPassword(signupForm.getPassword());
		
		 studentRepo.save(entity);
		 return "Registration Successfull";
	}

	@Override
	public boolean authenticate(String emailId, String password) {
		List<StudentEntity> studentOpt = studentRepo.findByEmailId(emailId);
	        if (!studentOpt.isEmpty()) {
	            StudentEntity student = studentOpt.get(0);
	            return student.getPassword().equals(password); // Simple plain text comparison
	        }
	        return false;
	}
	
	@Override
	@Transactional
	public String resetPwd(String emailId) {
		System.out.println(emailId);
		List<StudentEntity> optionalUser = studentRepo.findByEmailId(emailId);
		
        if (optionalUser.isEmpty()) {            
            return "Invalid User ";
        }
        
        String subject= "Password Reset Request";
        String resetUrl = "http://localhost:8080/forgotpwd1";
        String text = "<html><body><h3>Password Reset Request</h3> " +
        		 " <p>Click <a href='" + resetUrl +"'"
        		+ ">This Link here</a> to reset your password.</p></body></html>";
        emailutil.sendPasswordResetEmail(emailId, subject, text);
        
		return "Email Sent Successfully";     
	}

	
	
	  @Override	  
	  @Transactional 
	  public String resetPwd(String emailId, String newPassword,String confirmPassword) {
	  //System.out.println(emailId+" "+newPassword+" "+confirmPassword);
	  List<StudentEntity> optionalUser = studentRepo.findByEmailId(emailId);
	  
	  if (optionalUser.isEmpty()) { return "Invalid User "; }
	  
	  if (!newPassword.equals(confirmPassword)) { return "Passwords do not match!";
	  }
	  
	  int result = studentRepo.updatePassword(emailId, newPassword);
	  
	  if (result > 0) { return "Password changed successfully!"; } else { return
	  "Failed to change password."; }
	  
	  }
	 
}
