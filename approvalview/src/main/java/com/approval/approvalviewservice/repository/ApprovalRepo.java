package com.approval.approvalviewservice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.approval.approvalviewservice.model.Approval;

@Repository
@Transactional
public interface ApprovalRepo extends JpaRepository<Approval, String>{
	
	public Approval findByApprovalId(String approvalId);
	
	public List<Approval> findBySolverId(String solverId);
}
