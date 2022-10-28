package com.approval.approvalviewservice.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.approval.approvalviewservice.approvaldto.ApprovalResponseDto;
import com.approval.approvalviewservice.approvaldto.ApprovalStatusDto;
import com.approval.approvalviewservice.approvaldto.ApprovalStatusResponseDto;
import com.approval.approvalviewservice.exception.InvalidApproval;
import com.approval.approvalviewservice.exception.InvalidMember;
import com.approval.approvalviewservice.model.Approval;
import com.approval.approvalviewservice.model.Member;
import com.approval.approvalviewservice.repository.ApprovalRepo;
import com.approval.approvalviewservice.repository.MemberRepo;

@Service
public class ViewApprovalService {
	
	@Autowired
	private ApprovalRepo approvalRepo;
	
	@Autowired
	private MemberRepo memberRepo; 
	
	
	public List<Approval> fetchAllApproval(){
		
		return approvalRepo.findAll();
	}
	
	public List<Approval> fetchAllApprovalsByMemberId(String memberId) {
		
		return approvalRepo.findBySolverId(memberId);
	}
	
	public ResponseEntity<ApprovalStatusResponseDto> changeApprovalStatusById(ApprovalStatusDto approvalStatusDto, String memberId) throws InvalidMember, InvalidApproval{
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		String currentDate = formatter.format(date);
		
		Approval approval = approvalRepo.findByApprovalId(approvalStatusDto.getApprovalId());
		if(approval==null) {
			throw new InvalidApproval("Approval Doesnot Exist");
		}
		Member member = memberRepo.findByMid(memberId);
		if(!member.getRole().toLowerCase().equals("qa")) {
			throw new InvalidMember("Not valid member for status change");
		}
		
		approval.setStatus(approvalStatusDto.getApprovalStatus());
		approval.setApproverId(member.getMid());
		approval.setApproveDate(currentDate);
		approvalRepo.save(approval);
		
		
		ApprovalStatusResponseDto approvalStatusResponseDto = new ApprovalStatusResponseDto();
		approvalStatusResponseDto.setApproveDate(currentDate);
		approvalStatusResponseDto.setApproverId(member.getMid());
		approvalStatusResponseDto.setApprovalStatus(approvalStatusDto.getApprovalStatus());
		
		return new ResponseEntity<>(approvalStatusResponseDto, HttpStatus.OK);
	}
	
	public ResponseEntity<ApprovalResponseDto> getApprovalDetailsById(String approvalId) throws InvalidApproval{
		
		Approval approval = approvalRepo.findByApprovalId(approvalId);
		if(approval==null) {
			throw new InvalidApproval("Approval Doesnot Exist");
		}
		
		ApprovalResponseDto approvalResponseDto = new ApprovalResponseDto();
		approvalResponseDto.setApprovalId(approvalId);
		approvalResponseDto.setDescription(approval.getDescription());
		approvalResponseDto.setTestResult(approval.getTestResult());
		approvalResponseDto.setReleaseVersion(approval.getReleaseVersion());
		approvalResponseDto.setSolverName(approval.getSolverId());
		approvalResponseDto.setScrumTeamId(approval.getScrumTeamId());
		approvalResponseDto.setStatus(approval.getStatus());
		approvalResponseDto.setApproverId(approval.getApproverId());
		approvalResponseDto.setSubmitDate(approval.getSubmitDate());
		approvalResponseDto.setApproveDate(approval.getApproveDate());
		
		return new ResponseEntity<>(approvalResponseDto, HttpStatus.OK);
	}
}
