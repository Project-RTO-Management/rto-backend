package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.LearningLicenseRegister;
import com.app.entities.PermanentLicenseRegister;

public interface LicenseDao  extends  JpaRepository<LearningLicenseRegister, Long>{

	
	
	//Optional<LearningLicenseRegister> findLicenseIdByUserId(Long userId);
	Optional<LearningLicenseRegister> findByUserId(Long id);
}
