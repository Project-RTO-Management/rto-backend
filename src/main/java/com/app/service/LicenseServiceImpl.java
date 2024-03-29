package com.app.service;

import java.util.NoSuchElementException;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.message.Message;
import org.hibernate.query.criteria.internal.expression.function.TrimFunction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.LicenseDao;
import com.app.dao.UserDao;
import com.app.dto.LicenseDTO;
import com.app.dto.PermanentLicenseDTO;
import com.app.entities.LearningLicenseRegister;
import com.app.entities.PermanentLicenseRegister;
import com.app.entities.Result;
import com.app.entities.User;


@Service
@Transactional
public class LicenseServiceImpl implements LicenseService {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserDao userDao;
	@Autowired
	private LicenseDao dao;


  //generate learning license
  		public String generateRegistrationNumber() {
  	        String prefix = "DL"; // License prefix
  	        String uniqueNumber = generateUniqueNumber(); // Generate unique number

  	        // Combine prefix and unique number
  	        String licenseNumber = prefix + uniqueNumber;

  	        return licenseNumber;
  	    }
  		private String generateUniqueNumber() {
  	        // Generate a random number or use any other logic to ensure uniqueness
  	        Random random = new Random();
  	        int randomNumber = random.nextInt(99999); // Adjust as needed
			

  	        // Convert to a fixed length string
  	      return String.format("%05d", randomNumber); // 5-digit number
  	   
  }
 
  		
  		
	@Override
	public String generateLearningLicenseNo( @NotNull(message = "Id can not be null") Long userId,LicenseDTO licdto) {
		LearningLicenseRegister license = mapper.map(licdto,LearningLicenseRegister.class);
		System.out.println(license.toString());
		System.out.println(license.getAge() >18 && license.getAge() <60);
		System.out.println(String.valueOf(license.getAdharcardNumber()).length() == 12);
		if(license.getAge() >18 && license.getAge() <60 && String.valueOf(license.getAdharcardNumber()).length() == 12) {
		User user = userDao.findById(userId).orElseThrow(()-> new NoSuchElementException("Id can't fetched"));
		license.setLearningLicenseNo(this.generateRegistrationNumber());
		license.setUser(user);
		dao.save(license);
		
		return license.getLearningLicenseNo();
		}
		else
			return "Invalid: Age or AdharCard Number" ;
			//return "redirect:/users/home";
	}
	
	
	@Override
	public String applyForParmanentLicense(@NotNull(message = "Learning license can not be null") Long userId,
			PermanentLicenseDTO perdto) {
		PermanentLicenseRegister license = mapper.map(perdto, PermanentLicenseRegister.class);
		System.out.println(license.getLearningLicNo());
		System.out.println(license.getResultStatus());
	  User user = userDao.findById(userId).orElseThrow(()-> new NoSuchElementException("User not found"));
		LearningLicenseRegister learn = dao.findById(userId).orElseThrow(()-> new NoSuchElementException("Learning license not found"));
	  System.out.println(learn.getLearningLicenseNo().toString());
	  boolean b = license.getLearningLicNo().trim().equalsIgnoreCase(learn.getLearningLicenseNo().toString().trim()) ;
	  System.out.println(b);
	
	  if(license.getLearningLicNo().trim().equalsIgnoreCase(learn.getLearningLicenseNo().toString().trim())) {
		 // if(learn.getResult().getStatus().equalsIgnoreCase("PASS")) 
		  if(license.getResultStatus().equalsIgnoreCase("PASS")) {
			  license.setLearn(learn);
			  license.setUser(user);
			  dao.save(license);
			  return "Registration for Permanent License is successfull";}
		  return "Your Online Exam result is 'FAIL'. Please, Reappear for Exam";
	  }
		return "Please give correct Learning License Number";
	}

}














//@Override
//public String generateLearningLicenseNo(LicenseDTO dto, HttpSession session) {
//	LearningLicenseRegister license = mapper.map(dto,LearningLicenseRegister.class);
////	if(license.getAge() >18 && license.getAge() <60) {
//	User user = (User)session.getAttribute("user_details");
//	license.setLearningLicenseNo(this.generateRegistrationNumber());
//	license.setUser(user);
//	dao.save(license);
//	
//	return license.getLearningLicenseNo();
//	}
//	else
//		return "redirect:/users/home";
//}
