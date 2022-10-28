package com.approval.approvalcreation.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.approval.approvalcreation.model.Approval;

@Repository
@Transactional
public interface ApprovalRepo extends JpaRepository<Approval, String>{
	
	@Query(value = "SELECT max(approvalId) FROM Approval")
	public String getMaxApprovalId();
	
	public Approval findByApprovalId(String approvalId);
}
