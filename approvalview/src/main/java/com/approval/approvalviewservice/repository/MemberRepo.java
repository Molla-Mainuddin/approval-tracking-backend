package com.approval.approvalviewservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.approval.approvalviewservice.model.Member;

public interface MemberRepo extends JpaRepository<Member, String>{
	
	public Member findByMid(String mid);
}
