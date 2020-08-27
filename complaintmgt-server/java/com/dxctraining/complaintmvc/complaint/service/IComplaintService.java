package com.dxctraining.complaintmvc.complaint.service;

import java.util.List;

import com.dxctraining.complaintmvc.complaint.entities.Complaint;

public interface IComplaintService {
	public Complaint findComplaintById(int id);
	Complaint add(Complaint complaint);
	Complaint remove(int id);
	List<Complaint> allComplaints();
	List<Complaint> allComplaintsByConsumer(int consumerId);

}
