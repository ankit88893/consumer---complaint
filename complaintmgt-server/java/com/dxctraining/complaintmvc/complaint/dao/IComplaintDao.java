package com.dxctraining.complaintmvc.complaint.dao;

import java.util.List;

import com.dxctraining.complaintmvc.complaint.entities.Complaint;

public interface IComplaintDao {
	
	Complaint add(Complaint complaint);
	Complaint findComplaintById(int id);
	Complaint remove(int id);
	List<Complaint> allComplaints();
	List<Complaint> allComplaintsByConsumer(int consumerId);

}
