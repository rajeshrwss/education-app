package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AdminEntity;
import com.example.demo.entity.StudentEntity;

public interface AdminRepo extends JpaRepository<AdminEntity, String>{
	
	List<AdminEntity> findByEmailId(String emailId);

}
