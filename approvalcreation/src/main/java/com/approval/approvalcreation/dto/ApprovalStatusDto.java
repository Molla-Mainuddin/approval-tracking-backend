package com.approval.approvalcreation.dto;

public class ApprovalStatusDto {
	private String approvalId;

	private String description;

	private String releaseVersion;
	
	private String status;

	public ApprovalStatusDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApprovalStatusDto(String approvalId, String description, String releaseVersion, String status) {
		super();
		this.approvalId = approvalId;
		this.description = description;
		this.releaseVersion = releaseVersion;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ApprovalStatusDto [approvalId=" + approvalId + ", description=" + description + ", releaseVersion="
				+ releaseVersion + ", status=" + status + "]";
	}
	
	
}
