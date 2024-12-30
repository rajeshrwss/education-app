package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EnquiryEntity;
import com.example.demo.repo.EnquiryRepo;
import com.example.demo.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	private EnquiryRepo enquiryRepo;

	@Override
	public String postQuestion(EnquiryEntity enquiryEntity) {
		
		EnquiryEntity entity = new EnquiryEntity();
		entity.setMobileNumber(enquiryEntity.getMobileNumber());
		entity.setEmail(enquiryEntity.getEmail());
		entity.setName(enquiryEntity.getName());
		entity.setQuestion(enquiryEntity.getQuestion());
		
		enquiryRepo.save(entity);
		return "Your Question Reached Us. We Will Get Back to u Soon.";
	}

}
