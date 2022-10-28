package com.approval.approvalcreation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

	@Id
	@Column(name = "member_id")
	private String mid;

	@Column(name = "member_name")
	private String username;

	@Column(name = "member_password")
	private String password;

	@Column(name = "member_role")
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "solverId")
	private List<Approval> approvals = new ArrayList<>();
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String mid, String username, String password, String role) {
		super();
		this.mid = mid;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}

}
