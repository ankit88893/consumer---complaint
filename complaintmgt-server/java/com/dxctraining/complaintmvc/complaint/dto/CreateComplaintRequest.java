package com.dxctraining.complaintmvc.complaint.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateComplaintRequest {
	   @Size(min = 3)
	    @NotBlank
	private String description;
	   
	private Integer consumerId;

	public Integer getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
