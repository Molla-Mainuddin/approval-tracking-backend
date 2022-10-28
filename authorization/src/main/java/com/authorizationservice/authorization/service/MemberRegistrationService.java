package com.authorizationservice.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authorizationservice.authorization.exceptions.MemberIdNotAllowedFromUser;
import com.authorizationservice.authorization.model.RegistrationRequest;
import com.authorizationservice.authorization.repository.RegistrationRequestRepo;

@Service
public class MemberRegistrationService {
	
	@Autowired
	RegistrationRequestRepo registrationRequestRepo;
	
	
	public RegistrationRequest registerNewMember(RegistrationRequest registrationRequest) throws MemberIdNotAllowedFromUser {
		
		if(registrationRequest.getMid()!=null) {
			throw new MemberIdNotAllowedFromUser("Member Id is not acceptable from user end");
		}
		registrationRequest.setMid("M"+generateMemberId());
		
		return registrationRequestRepo.save(registrationRequest);
	}
	
	
	private String generateMemberId() {
		String maxId = registrationRequestRepo.getMaxId();
		if(maxId==null) {
			return String.valueOf(1000);//"M1000"
		}else {
			int id = Integer.parseInt(maxId.substring(1))+1;
			return String.valueOf(id);
		}
	}
}
