package com.approval.approvalviewservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "approvals")
public class Approval {

	@Id
	@Column(name = "approval_id")
	private String approvalId;

	@Column(name = "approval_description")
	private String description;

	@Column(name = "release_version")
	private String releaseVersion;

	@Column(name = "test_result")
	private String testResult;

	@Column(name = "solver_id")
	private String solverId;

	@Column(name = "scrumteam_id")
	private String scrumTeamId;

	@Column(name = "status")
	private String status;

	@Column(name = "approver_id")
	private String approverId;

	@Column(name = "submit_date")
	private String submitDate;

	@Column(name = "approve_date")
	private String approveDate;

	public Approval() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Approval(String approvalId, String description, String releaseVersion, String testResult, String solverId,
			String scrumTeamId, String status, String approverId, String submitDate, String approveDate) {
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
		return "Approval [approvalId=" + approvalId + ", description=" + description + ", releaseVersion="
				+ releaseVersion + ", testResult=" + testResult + ", solverId=" + solverId + ", scrumTeamId="
				+ scrumTeamId + ", status=" + status + ", approverId=" + approverId + ", submitDate=" + submitDate
				+ ", approveDate=" + approveDate + "]";
	}

}
