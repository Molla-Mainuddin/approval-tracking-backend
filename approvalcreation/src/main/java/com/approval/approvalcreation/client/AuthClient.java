package com.approval.approvalcreation.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.approval.approvalcreation.dto.ValidatingDto;

@FeignClient(name = "auth-client", url = "${Authorization.URL}")
public interface AuthClient {
	
	@GetMapping(value = "/validate")
	public ValidatingDto getsValidity(@RequestHeader(name = "Authorization", required = true) String token);
	
}
