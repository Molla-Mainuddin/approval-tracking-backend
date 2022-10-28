package com.authorizationservice.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authorizationservice.authorization.exceptions.UserAlreadyExistException;
import com.authorizationservice.authorization.model.RegistrationRequest;
import com.authorizationservice.authorization.repository.RegistrationRequestRepo;
import com.authorizationservice.authorization.service.MemberRegistrationService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Registration endpoints for Authorization Service")
@CrossOrigin("*")
public class RegistrationController {

	@Autowired
	RegistrationRequestRepo registrationRequestRepo;
	
	@Autowired
	MemberRegistrationService memberRegistrationService;

	@PostMapping("/register")
	public RegistrationRequest registerNewMember(@RequestBody RegistrationRequest registrationRequest)
			throws Exception {

		RegistrationRequest result = registrationRequestRepo.findByMid(registrationRequest.getMid());
		
		if (result != null) {
			throw new UserAlreadyExistException("Member Already Exist");
		} else {
			return memberRegistrationService.registerNewMember(registrationRequest);
		}
	}
}
