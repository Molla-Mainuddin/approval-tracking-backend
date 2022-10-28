package com.approval.approvalviewservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.approval.approvalviewservice.approvaldto.ApprovalStatusDto;
import com.approval.approvalviewservice.approvaldto.ApprovalStatusResponseDto;
import com.approval.approvalviewservice.approvaldto.ApprovalResponseDto;
import com.approval.approvalviewservice.client.AuthClient;
import com.approval.approvalviewservice.exception.InvalidTokenException;
import com.approval.approvalviewservice.model.Approval;
import com.approval.approvalviewservice.service.ViewApprovalService;

@RestController
@CrossOrigin("*")
public class ApprovalViewController {
	
	@Autowired
	private ViewApprovalService viewApprovalService;
	
	@Autowired
	private AuthClient authClient;
	
	private static final Logger log = LoggerFactory.getLogger(ApprovalViewController.class);
	
	
	@GetMapping(value = "/getAllApprovals")
	public List<Approval> fetchAllApproval(@RequestHeader(name = "Authorization", required = true) String token) throws InvalidTokenException {
		
		log.info("Request Came in [fecthAllApproval()] method");
		log.info(token);
		
		if(!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		
		return viewApprovalService.fetchAllApproval(); 
	}
	
	@GetMapping(value = "/getApprovals/{memberId}")
	public List<Approval> fecthAllApprovalsByMemberId(@PathVariable("memberId") String memberId , @RequestHeader(name = "Authorization", required = true) String token) throws InvalidTokenException{
		
		log.info("Request Came in [fecthAllApprovalsByMemberName()] method");
		log.info(token);
		if(!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		
		return viewApprovalService.fetchAllApprovalsByMemberId(memberId);
	}
	
	@GetMapping(value = "/getApprovalDetailsById/{approvalId}")
	public ResponseEntity<ApprovalResponseDto> getApprovalDetailsById(@PathVariable("approvalId") String approvalId, @RequestHeader(name = "Authorization", required = true) String token) throws Exception{
		log.info("Request Came in [ getApprovalDetailsById() ] method");
		log.info(token);
		if(!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		return viewApprovalService.getApprovalDetailsById(approvalId);
	}
	
	@PutMapping(value = "/changeApprovalStatusById/{memberId}")
	public ResponseEntity<ApprovalStatusResponseDto> changeApprovalStatusById(@PathVariable("memberId") String memberId,@RequestBody ApprovalStatusDto approvalStatusDto, @RequestHeader(name = "Authorization", required = true) String token) throws Exception {
		
		log.info("Request Came in [changeApprovalStatusById()] method");
		log.info(token);
		if(!authClient.getsValidity(token).isValidStatus()) {
			throw new InvalidTokenException("Token is either expired or invalid");
		}
		
		return viewApprovalService.changeApprovalStatusById(approvalStatusDto, memberId);
	}
}
