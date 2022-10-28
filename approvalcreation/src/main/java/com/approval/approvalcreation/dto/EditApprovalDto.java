package com.approval.approvalcreation.dto;

public class EditApprovalDto {
	
	private String approvalId;
	
	private String description;
	
	private String releaseVersion;
	
	private String testResult;
	
	private String scrumTeamId;

	public EditApprovalDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EditApprovalDto(String approvalId, String description, String releaseVersion, String testResult,
			String scrumTeamId) {
		super();
		this.approvalId = approvalId;
		this.description = description;
		this.releaseVersion = releaseVersion;
		this.testResult = testResult;
		this.scrumTeamId = scrumTeamId;
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

	public String getScrumTeamId() {
		return scrumTeamId;
	}

	public void setScrumTeamId(String scrumTeamId) {
		this.scrumTeamId = scrumTeamId;
	}

	@Override
	public String toString() {
		return "EditApprovalDto [approvalId=" + approvalId + ", description=" + description + ", releaseVersion="
				+ releaseVersion + ", testResult=" + testResult + ", scrumTeamId=" + scrumTeamId + "]";
	}

	
}
