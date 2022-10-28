package com.approval.approvalcreation.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.approval.approvalcreation.model.Member;

@Repository
@Transactional
public interface MemberRepo extends JpaRepository<Member, String>{
	
	public Member findByMid(String mid);
}
