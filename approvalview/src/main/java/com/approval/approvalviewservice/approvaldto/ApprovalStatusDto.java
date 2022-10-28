package com.approval.approvalviewservice.approvaldto;

public class ApprovalStatusDto {
	
	private String approvalId;
	
	private String approvalStatus;

	public ApprovalStatusDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApprovalStatusDto(String approvalId, String approvalStatus) {
		super();
		this.approvalId = approvalId;
		this.approvalStatus = approvalStatus;
	}

	public String getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	@Override
	public String toString() {
		return "ApprovalStatusDto [approvalId=" + approvalId + ", approvalStatus=" + approvalStatus + "]";
	}
	
	
}
