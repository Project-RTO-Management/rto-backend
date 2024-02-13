package com.app.service;

import javax.validation.constraints.NotNull;

import com.app.dto.VehRegDTO;

public interface vehicalRegService {

	public VehRegDTO generateRegistrationNo(VehRegDTO vehregdto,@NotNull(message = "Id can not be null") Long userId);

}
