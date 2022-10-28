package com.approval.approvalcreation.dto;

public class ApprovalMaxIdDto {
	
	private String maxApprovalId;

	public ApprovalMaxIdDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApprovalMaxIdDto(String maxApprovalId) {
		super();
		this.maxApprovalId = maxApprovalId;
	}

	public String getMaxApprovalId() {
		return maxApprovalId;
	}

	public void setMaxApprovalId(String maxApprovalId) {
		this.maxApprovalId = maxApprovalId;
	}

	@Override
	public String toString() {
		return "ApprovalMaxIdDto [maxApprovalId=" + maxApprovalId + "]";
	}
	
	
}
