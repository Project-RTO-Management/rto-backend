package com.app.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.LicenseDao;
import com.app.entities.LearningLicenseRegister;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	private LicenseDao licensedao;

	@Override
	public String applyForExam(Long userId, String license) {
		System.out.println(license);
		LearningLicenseRegister lic = licensedao.findByUserId(userId)
				.orElseThrow(() -> new NoSuchElementException());
		System.out.println(lic.getLearningLicenseNo());
		if(license.equalsIgnoreCase(lic.getLearningLicenseNo()))
			return "Valid,Start exam";
		else
			return "Invalid License No.";
	}

}
