package com.dxctraining.complaintmvc.complaint.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.complaintmvc.complaint.dao.IComplaintDao;
import com.dxctraining.complaintmvc.complaint.entities.Complaint;

@Transactional
@Service
public class ComplaintServiceImpl implements IComplaintService {

	@Autowired
	private IComplaintDao dao;

	@Override
	public Complaint findComplaintById(int id) {
		Complaint complaint = dao.findComplaintById(id);
		return complaint;

	}

	@Override
	public Complaint add(Complaint complaint) {
		complaint = dao.add(complaint);
		return complaint;

	}

	@Override
	public Complaint remove(int id) {
		Complaint complaint = dao.remove(id);
		return complaint;
	}

	@Override
	public List<Complaint> allComplaints() {
		List<Complaint> complaint = dao.allComplaints();
		return complaint;
	}
	@Override
	public List<Complaint> allComplaintsByConsumer(int consumerId) {
		List<Complaint> list=dao.allComplaintsByConsumer(consumerId);
		return list;
	}


}
