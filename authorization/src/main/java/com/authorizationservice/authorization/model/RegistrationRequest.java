package com.authorizationservice.authorization.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.authorizationservice.authorization.repository.RegistrationRequestRepo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Creating model class for user logging in")
@Table(name = "member")
public class RegistrationRequest {
	
	@Id
	@Column(name = "member_id")
	@ApiModelProperty(value = "Member id of the Customer doing login")
	private String mid;

	@Column(name = "member_name")
	@ApiModelProperty(value = "Username of the Customer doing login")
	private String username;

	@Column(name = "member_password")
	@ApiModelProperty(value = "Password of the Customer doing login")
	private String password;

	@Column(name = "member_role")
	@ApiModelProperty(value = "Role of the Member doing login")
	private String role;
	
	
	public RegistrationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistrationRequest(String mid, String username, String password, String role) {
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
		return "RegistrationRequest [mid=" + mid + ", username=" + username + ", password=" + password + ", role="
				+ role + "]";
	}

}
