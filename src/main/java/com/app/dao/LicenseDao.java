package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.LearningLicenseRegister;
import com.app.entities.PermanentLicenseRegister;

public interface LicenseDao  extends  JpaRepository<LearningLicenseRegister, Long>{

	void save(PermanentLicenseRegister license);

}