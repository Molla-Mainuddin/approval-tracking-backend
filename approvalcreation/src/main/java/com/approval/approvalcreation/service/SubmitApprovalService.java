package com.approval.approvalcreation.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.approval.approvalcreation.dto.ApprovalDto;
import com.approval.approvalcreation.dto.ApprovalMaxIdDto;
import com.approval.approvalcreation.dto.ApprovalStatusDto;
import com.approval.approvalcreation.dto.EditApprovalDto;
import com.approval.approvalcreation.exception.InvalidApprovalId;
import com.approval.approvalcreation.exception.InvalidMemberId;
import com.approval.approvalcreation.model.Approval;
import com.approval.approvalcreation.model.Member;
import com.approval.approvalcreation.repository.ApprovalRepo;
import com.approval.approvalcreation.repository.MemberRepo;

@Service
public class SubmitApprovalService {

	@Autowired
	private ApprovalRepo approvalRepo;
	
	@Autowired	
	private MemberRepo memberRepo; 
	
	private static final Logger log = LoggerFactory.getLogger(SubmitApprovalService.class);

	public ResponseEntity<ApprovalStatusDto> submitApproval(ApprovalDto approvalDto) throws InvalidMemberId, InvalidApprovalId {
		
		log.info("inside the submit approval service method : BEGIN");
		
		log.info("Finding Member using Member id : BEGIN");
		Member member = memberRepo.findByMid(approvalDto.getSolverId());
		if(member==null) {
			throw new InvalidMemberId("Mamber Id is not valid");
		}
		log.info("Finding Member using Member id : END");
		
		if(approvalRepo.findByApprovalId(approvalDto.getApprovalId())!=null) {
			throw new InvalidApprovalId("Approval Already Exist");
		}
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		String currentDate = formatter.format(date);
		
		log.info("creating approval and setting the status : BEGIN");
		Approval approval = new Approval();
		approval.setApprovalId(approvalDto.getApprovalId());
		approval.setDescription(approvalDto.getDescription());
		approval.setReleaseVersion(approvalDto.getReleaseVersion());
		approval.setTestResult(approvalDto.getTestResult());
		approval.setSolverId(member);
		approval.setScrumTeamId(approvalDto.getScrumTeamId());
		approval.setStatus("Pending");
		approval.setApproverId(approvalDto.getApproverId());
		approval.setSubmitDate(currentDate);
//		approval.setApproveDate(approveDate);
		log.info("setting the status : ENDED");
		
		log.info("saving approval data into database approval table : BEGIN");
		approvalRepo.save(approval);
		log.info("saving approval data into database approval table : END");
		
		ApprovalStatusDto approvalStatusDto = new ApprovalStatusDto();
		approvalStatusDto.setApprovalId(approval.getApprovalId());
		approvalStatusDto.setDescription(approval.getDescription());
		approvalStatusDto.setReleaseVersion(approval.getReleaseVersion());
		approvalStatusDto.setStatus(approval.getStatus());
		
		log.info("Returning Response to Submit Claim Controller : BEGIN");
		return new ResponseEntity<>(approvalStatusDto, HttpStatus.OK);
	}
	
//	private String generateApprovalId() {
//		log.info("Approval Id Generating : BEGIN");
//		String maxId = approvalRepo.getMaxApprovalId();
//		if(maxId==null) {
//			log.info("Approval Id is Generating For First Time : END");
//			return String.valueOf(1000);
//		}else {
//			int id = Integer.parseInt(maxId.substring(1))+1;
//			log.info("Approval Id is Generating : END");
//			return String.valueOf(id);
//		}
//	}
	
	public ResponseEntity<EditApprovalDto> editApprovalById(EditApprovalDto editApprovalDto) throws InvalidApprovalId{
		
		Approval approval = approvalRepo.findByApprovalId(editApprovalDto.getApprovalId());
		if(approval==null) {
			throw new InvalidApprovalId("Approval Does not Exist");
		}
		
		approval.setDescription(editApprovalDto.getDescription());
		approval.setReleaseVersion(editApprovalDto.getReleaseVersion());
		approval.setTestResult(editApprovalDto.getTestResult());
		approval.setScrumTeamId(editApprovalDto.getScrumTeamId());
		
		approvalRepo.save(approval);
		
		return new ResponseEntity<>(editApprovalDto, HttpStatus.OK);
	}
	
	public String deleteApprovalByApprovalId(String approvalId) throws InvalidApprovalId {
		log.info("Approval Find By Id : BEGIN");
		Approval approval = approvalRepo.findByApprovalId(approvalId);
		log.info("Approval Find By Id : END");
		if(approval!=null) {
			log.info("Approval Deletion Process : BEGIN");
			approvalRepo.deleteById(approvalId);
			log.info("Approval Deletion Process : END");
			return "Approval Deleted Successfully";
		}else {
			log.info("Exception Occured During Approval Deletion Process");
			throw new InvalidApprovalId("Approval Id not Found");
		}
	}
	
	public ResponseEntity<ApprovalMaxIdDto> getLastApprovalId() {
		
		String maxId =  approvalRepo.getMaxApprovalId();
		ApprovalMaxIdDto approvalMaxIdDto = new ApprovalMaxIdDto();
		approvalMaxIdDto.setMaxApprovalId(maxId);
		return new ResponseEntity<>(approvalMaxIdDto, HttpStatus.OK);
	}
}
