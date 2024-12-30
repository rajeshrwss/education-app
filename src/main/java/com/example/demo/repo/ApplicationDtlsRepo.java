package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ApplicationEntity;

public interface ApplicationDtlsRepo extends JpaRepository<ApplicationEntity, Long>{

}
