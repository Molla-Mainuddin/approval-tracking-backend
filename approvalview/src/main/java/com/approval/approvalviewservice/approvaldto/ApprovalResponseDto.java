package com.approval.approvalviewservice.approvaldto;

import java.util.Date;

public class ApprovalResponseDto {
	private String approvalId;

	private String description;

	private String releaseVersion;

	private String testResult;

	private String solverName;

	private String scrumTeamId;

	private String status;

	private String approverId;

	private String submitDate;

	private String approveDate;

	public ApprovalResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApprovalResponseDto(String approvalId, String description, String releaseVersion, String testResult,
			String solverName, String scrumTeamId, String status, String approverId, String submitDate,
			String approveDate) {
		super();
		this.approvalId = approvalId;
		this.description = description;
		this.releaseVersion = releaseVersion;
		this.testResult = testResult;
		this.solverName = solverName;
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

	public String getSolverName() {
		return solverName;
	}

	public void setSolverName(String solverName) {
		this.solverName = solverName;
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

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}

	@Override
	public String toString() {
		return "ApprovalResponseDto [approvalId=" + approvalId + ", description=" + description + ", releaseVersion="
				+ releaseVersion + ", testResult=" + testResult + ", solverName=" + solverName + ", scrumTeamId="
				+ scrumTeamId + ", status=" + status + ", approverId=" + approverId + ", submitDate=" + submitDate
				+ ", approveDate=" + approveDate + "]";
	}

}
