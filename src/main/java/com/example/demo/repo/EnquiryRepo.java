package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EnquiryEntity;

@Repository
public interface EnquiryRepo extends JpaRepository<EnquiryEntity, Long>{
	
}
