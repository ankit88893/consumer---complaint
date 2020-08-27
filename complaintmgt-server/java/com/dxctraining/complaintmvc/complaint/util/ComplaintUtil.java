package com.dxctraining.complaintmvc.complaint.util;

import org.springframework.stereotype.Component;

import com.dxctraining.complaintmvc.complaint.dto.ComplaintDto;
import com.dxctraining.complaintmvc.complaint.entities.Complaint;
@Component
public class ComplaintUtil {

	public ComplaintDto complaintDto(Complaint complaint, int consumerId, String consumerName) {
		ComplaintDto dto=new ComplaintDto(complaint.getId(),complaint.getDescription());
		dto.setConsumerId(consumerId);
		dto.setConsumerName(consumerName);
		return dto;
	}

}
