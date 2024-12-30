package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ApplicationEntity;
import com.example.demo.repo.ApplicationDtlsRepo;
import com.example.demo.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService{

	@Autowired
	private ApplicationDtlsRepo appRepo;
	
	@Override
	public ApplicationEntity saveApplicationDtls(ApplicationEntity appEntity) {

		ApplicationEntity entity = new ApplicationEntity();
		entity.setAcadamicPercentage(appEntity.getAcadamicPercentage());
		entity.setActivity(appEntity.getActivity());
		entity.setCareerGoal(appEntity.getCareerGoal());
		entity.setCitizenShip(appEntity.getCitizenShip());
		entity.setCollege(appEntity.getCollege());
		entity.setCountry(appEntity.getCountry());
		entity.setDocuments(appEntity.getDocuments());
		entity.setEmail(appEntity.getEmail());
		entity.setEngProficiency(appEntity.getEngProficiency());
		entity.setGradCourse(appEntity.getGradCourse());
		entity.setInterest(appEntity.getInterest());
		entity.setPackageInfo(appEntity.getPackageInfo());
		entity.setPhoneNumber(appEntity.getPhoneNumber());
		entity.setPurpose(appEntity.getPurpose());
		entity.setSop(appEntity.getSop());
		entity.setStudentName(appEntity.getStudentName());
		entity.setSummary(appEntity.getSummary());
		entity.setTestResult(appEntity.getTestResult());
		
		ApplicationEntity appEnt =  appRepo.save(entity);
		
		return appEnt;
	}

	@Override	
		public List<ApplicationEntity> getAllApplications() {
	        return appRepo.findAll();  // This fetches all the records from the table	   
	}
	
}
