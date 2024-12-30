package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AdminEntity;
import com.example.demo.repo.AdminRepo;
import com.example.demo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	public boolean authenticate(String emailId, String password) {
		List<AdminEntity> adminOpt = adminRepo.findByEmailId(emailId);
        if (!adminOpt.isEmpty()) {
            AdminEntity admin = adminOpt.get(0);
            return admin.getPassword().equals(password); // Simple plain text comparison
        }        
		return false;
	}

}
