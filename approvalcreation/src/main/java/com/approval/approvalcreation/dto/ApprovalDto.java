package com.approval.approvalcreation.dto;

import java.util.Date;

public class ApprovalDto {
	
	private String approvalId;
	
	private String description;
	
	private String releaseVersion;
	
	private String testResult;
	
	private String solverId;
	
	private String scrumTeamId;
	
	private String status;
	
	private String approverId;
	
	private Date submitDate;
	
	private Date approveDate;

	public ApprovalDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ApprovalDto(String approvalId, String description, String releaseVersion, String testResult, String solverId,
			String scrumTeamId, String status, String approverId, Date submitDate, Date approveDate) {
		super();
		this.approvalId = approvalId;
		this.description = description;
		this.releaseVersion = releaseVersion;
		this.testResult = testResult;
		this.solverId = solverId;
		this.scrumTeamId = scrumTeamId;
		this.status = status;
		this.approverId = approverId;
		this.submitDate = submitDate;
		this.approveDate = approveDate;
	}

	public String getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReleaseVersion() {
		return releaseVersion;
	}

	public void setReleaseVersion(String releaseVersion) {
		this.releaseVersion = releaseVersion;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public String getSolverId() {
		return solverId;
	}

	public void setSolverId(String solverId) {
		this.solverId = solverId;
	}

	public String getScrumTeamId() {
		return scrumTeamId;
	}

	public void setScrumTeamId(String scrumTeamId) {
		this.scrumTeamId = scrumTeamId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	@Override
	public String toString() {
		return "ApprovalDto [approvalId=" + approvalId + ", description=" + description + ", releaseVersion="
				+ releaseVersion + ", testResult=" + testResult + ", solverId=" + solverId + ", scrumTeamId="
				+ scrumTeamId + ", status=" + status + ", approverId=" + approverId + ", submitDate=" + submitDate
				+ ", approveDate=" + approveDate + "]";
	}

}
