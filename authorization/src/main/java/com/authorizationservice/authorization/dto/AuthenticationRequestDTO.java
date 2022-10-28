package com.authorizationservice.authorization.dto;

public class AuthenticationRequestDTO {
	
	private String memberId;
	
	private String username;

	private String password;

	

	public AuthenticationRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationRequestDTO(String username, String password, String memberId) {
		super();
		this.username = username;
		this.password = password;
		this.memberId = memberId;
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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "AuthenticationRequestDTO [username=" + username + ", password=" + password + ", memberId=" + memberId
				+ "]";
	}
	
	
}
