package com.authorizationservice.authorization.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authorizationservice.authorization.model.AuthenticationRequest;
import com.authorizationservice.authorization.repository.AuthRequestRepo;

@Service
public class AppUserDetailsService implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);
	@Autowired
	AuthRequestRepo authRequestRepo;

	@Override
	public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
		logger.info("Member is Coming..."+memberId);
		logger.info("BEGIN - [loadUserByUsername()]");
		logger.debug("Member Id : " + memberId);
		AuthenticationRequest authenticationRequest;
		
		if(authRequestRepo.findById(memberId).get() != null) {
			authenticationRequest = authRequestRepo.findById(memberId).get();
			UserDetails user = new User(authenticationRequest.getMid(), authenticationRequest.getPassword(),
					new ArrayList<>());
			
			logger.debug("User : " + user);
			logger.info("END - [loadUserByUsername()]");
			return user;
		}
		
		throw new UsernameNotFoundException("User not found!!");
	}
	
	public AuthenticationRequest getUser(String memberId) {
		return authRequestRepo.findById(memberId).get();
	}

	public void saveUser(AuthenticationRequest user) {
		authRequestRepo.save(user);
	}

}
