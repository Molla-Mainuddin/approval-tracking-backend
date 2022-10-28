package com.approval.approvalviewservice.approvaldto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidatingDto {
	
	@JsonProperty
	private boolean validStatus;

	public ValidatingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidatingDto(boolean validStatus) {
		super();
		this.validStatus = validStatus;
	}

	public boolean isValidStatus() {
		return validStatus;
	}

	public void setValidStatus(boolean validStatus) {
		this.validStatus = validStatus;
	}

	@Override
	public String toString() {
		return "ValidatingDto [validStatus=" + validStatus + "]";
	}
}
