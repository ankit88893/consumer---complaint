package com.dxctraining.complaintmvc.complaint.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.complaintmvc.complaint.dto.ComplaintDto;
import com.dxctraining.complaintmvc.complaint.dto.ConsumerDto;
import com.dxctraining.complaintmvc.complaint.dto.CreateComplaintRequest;
import com.dxctraining.complaintmvc.complaint.entities.Complaint;
import com.dxctraining.complaintmvc.complaint.service.IComplaintService;
import com.dxctraining.complaintmvc.complaint.util.ComplaintUtil;
@Validated
@RestController
@RequestMapping("/complaints")
public class ComplaintController {

	@Autowired
	private IComplaintService service;

	@Autowired
	private ComplaintUtil util;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ComplaintDto add(@RequestBody @Valid CreateComplaintRequest request) {
		String description = request.getDescription();
		int consumerId = request.getConsumerId();
		Complaint complaint = new Complaint(description, consumerId);
		complaint = service.add(complaint);
		ConsumerDto consumerDto = fetchFromConsumerById(consumerId);
		ComplaintDto response = util.complaintDto(complaint, consumerId, consumerDto.getName());
		return response;

	}

	@GetMapping("/get/{id}")
	public ComplaintDto get( @NotBlank @PathVariable("id") int id) {
		Complaint complaint = service.findComplaintById(id);
		int consumerId = complaint.getConsumerId();
		ConsumerDto consumerDto = fetchFromConsumerById(consumerId);
		ComplaintDto response = util.complaintDto(complaint, consumerId, consumerDto.getName());
		return response;
	}

	@GetMapping("/allcomplaints")
	public List<ComplaintDto> fetchAll() {
		List<Complaint> list = service.allComplaints();
		List<ComplaintDto> response = new ArrayList<>();
		for (Complaint complaint : list) {
			int consumerId = complaint.getConsumerId();
			ConsumerDto consumerDto = fetchFromConsumerById(consumerId);
			ComplaintDto dto = util.complaintDto(complaint, consumerId, consumerDto.getName());
			response.add(dto);
		}
		return response;
	}

	@GetMapping("/consumer/{consumerId}")
	public List<ComplaintDto> fetchAllComplaints(@PathVariable("consumerId") int consumerId) {
		List<Complaint> list = service.allComplaintsByConsumer(consumerId);
		List<ComplaintDto> response = new ArrayList<>();
		ConsumerDto consumerDto = fetchFromConsumerById(consumerId);
		for (Complaint complaint : list) {
			ComplaintDto dto = util.complaintDto(complaint, consumerId, consumerDto.getName());
			response.add(dto);
		}
		return response;
	}

	public ConsumerDto fetchFromConsumerById(int consumerId) {
		String url = "http://localhost:8585/consumer/get/" + consumerId;
		ConsumerDto dto = restTemplate.getForObject(url, ConsumerDto.class);
		return dto;
	}
}