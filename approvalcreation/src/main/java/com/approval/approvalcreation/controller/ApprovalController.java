package com.approval.approvalcreation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.approval.approvalcreation.client.AuthClient;
import com.approval.approvalcreation.dto.ApprovalDto;
import com.approval.approvalcreation.dto.ApprovalMaxIdDto;
import com.approval.approvalcreation.dto.ApprovalStatusDto;
import com.approval.approvalcreation.dto.EditApprovalDto;
import com.approval.approvalcreation.exception.InvalidMemberId;
import com.approval.approvalcreation.exception.InvalidTokenException;
import com.approval.approvalcreation.service.SubmitApprovalService;

@RestController
@CrossOrigin("*")
public class ApprovalController {
	
	@Autowired
	private SubmitApprovalService submitApprovalService;
	
	@Autowired
	private AuthClient authClient;
	
	private static final Logger log = LoggerFactory.getLogger(ApprovalController.class);
	
	@PostMapping(path = "/submitApproval")
	public ResponseEntity<ApprovalStatusDto> submitApproval(@RequestBody ApprovalDto approvalDto, @RequestHeader(name = "Authorization", required = true) String token) throws Exception{
		log.info("Request Came in submit Approval");
		log.info(token);
//		System.out.println(authClient.getsValidity(token).isValidStatus());
		if(!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		
		log.info("inside the submit Approval Service : BEGIN");
		return submitApprovalService.submitApproval(approvalDto);
	}
	
	@DeleteMapping(path = "/deleteApproval/{approvalId}")
	public String deleteApproval(@PathVariable("approvalId") String approvalId, @RequestHeader(name = "Authorization", required = true) String token) throws Exception {
		
		log.info("Request Came in Delete Approval");
		log.info(token);
		if(!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		
		return submitApprovalService.deleteApprovalByApprovalId(approvalId);
	}
	
	@PutMapping(path = "/editApproval")
	public ResponseEntity<EditApprovalDto> editApprovalById(@RequestBody EditApprovalDto editApprovalDto, @RequestHeader(name = "Authorization", required = true) String token) throws Exception{
		
		log.info("Request Came in [editApprovalById()] method");
		log.info(token);
		if(!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		return submitApprovalService.editApprovalById(editApprovalDto);
	}
	
	@GetMapping(path = "/getLastApprovalId")
	public ResponseEntity<ApprovalMaxIdDto> getLastApprovalId(@RequestHeader(name = "Authorization", required = true) String token) throws Exception {
		
		log.info("Request Came in [getLastApprovalId()] method");
		log.info(token);
		if(!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		return submitApprovalService.getLastApprovalId();
	}
}
