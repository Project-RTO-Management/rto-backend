package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.entities.LearningLicenseRegister;
@Repository
public abstract class LicenseDaoImpl implements LicenseDao {
	@Autowired
	private LearningLicenseRegister license;
}
