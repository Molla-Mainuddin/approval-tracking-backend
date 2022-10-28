package com.authorizationservice.authorization.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Creating model class for generating authorization token when any customer logs in")

public class AuthenticationResponse {

    @ApiModelProperty(value = "id of the Customer doing login")
    private String mid;
    
    @ApiModelProperty(value = "Username of the Customer doing login")
    private String username;
    
    @ApiModelProperty(value = "Role of the Member doing login")
    private String role;
    
	@ApiModelProperty(value = "Authorization token of the customer")
    private String jwtAuthToken;
    
    private long serverCurrentTime;

    private long tokenExpirationTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getJwtAuthToken() {
		return jwtAuthToken;
	}

	public void setJwtAuthToken(String jwtAuthToken) {
		this.jwtAuthToken = jwtAuthToken;
	}

	public long getServerCurrentTime() {
		return serverCurrentTime;
	}

	public void setServerCurrentTime(long serverCurrentTime) {
		this.serverCurrentTime = serverCurrentTime;
	}

	public long getTokenExpirationTime() {
		return tokenExpirationTime;
	}

	public void setTokenExpirationTime(long tokenExpirationTime) {
		this.tokenExpirationTime = tokenExpirationTime;
	}

	public AuthenticationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationResponse(String mid, String username, String role, String jwtAuthToken, long serverCurrentTime,
			long tokenExpirationTime) {
		super();
		this.mid = mid;
		this.username = username;
		this.role = role;
		this.jwtAuthToken = jwtAuthToken;
		this.serverCurrentTime = serverCurrentTime;
		this.tokenExpirationTime = tokenExpirationTime;
	}

	@Override
	public String toString() {
		return "AuthenticationResponse [mid=" + mid + ", username=" + username + ", role=" + role + ", jwtAuthToken="
				+ jwtAuthToken + ", serverCurrentTime=" + serverCurrentTime + ", tokenExpirationTime="
				+ tokenExpirationTime + "]";
	}
    
}
