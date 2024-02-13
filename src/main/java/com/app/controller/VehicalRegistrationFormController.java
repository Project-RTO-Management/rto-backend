package com.app.controller;


import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.VehRegDTO;
import com.app.service.vehicalRegService;

@RestController
@RequestMapping("/vehicalRegistration")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class VehicalRegistrationFormController{
	
	@Autowired
	public vehicalRegService service;
	

	 
	 @PostMapping("/vehReg/{userId}")
	public ResponseEntity<?> vehGenerator(@PathVariable @NotNull(message = "Id can not be null") Long userId, @RequestBody VehRegDTO vehregdto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.generateRegistrationNo(vehregdto,userId));
	}
}


