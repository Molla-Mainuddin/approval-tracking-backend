package com.approval.approvalviewservice.approvaldto;

public class ApprovalStatusResponseDto {

	private String approverId;

	private String approveDate;

	private String approvalStatus;

	public ApprovalStatusResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApprovalStatusResponseDto(String approverId, String approveDate, String approvalStatus) {
		super();
		this.approverId = approverId;
		this.approveDate = approveDate;
		this.approvalStatus = approvalStatus;
	}

	public String getApproverId() {
		return approverId;
	}

	public void setApproverId(String approverId) {
		this.approverId = approverId;
	}

	public String getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	@Override
	public String toString() {
		return "ApprovalStatusResponseDto [approverId=" + approverId + ", approveDate=" + approveDate
				+ ", approvalStatus=" + approvalStatus + "]";
	}

}
