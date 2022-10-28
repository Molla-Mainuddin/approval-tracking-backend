package com.approval.approvalcreation.dto;

public class MemberDto {
	
	private String mid;
	
	private String username;

	private String password;

	private String role;

	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberDto(String mid, String username, String password, String role) {
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
		return "MemberDto [mid=" + mid + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
