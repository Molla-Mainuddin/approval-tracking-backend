package com.authorizationservice.authorization.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.authorizationservice.authorization.model.RegistrationRequest;

@Repository
@Transactional
public interface RegistrationRequestRepo extends JpaRepository<RegistrationRequest, String>{
	
	public RegistrationRequest findByMid(String memberId);
	
	@Query(value = "SELECT max(mid) FROM RegistrationRequest")
	public String getMaxId();
}
