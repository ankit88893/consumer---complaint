package com.dxctraining.complaintmvc.complaint.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "complains")
@Entity
public class Complaint {
	@Id
	@GeneratedValue
	private Integer id;
	private String description;
	private Integer consumerId;

	public Complaint() {

	}

	public Complaint(String description, int consumerId) {
		this.description = description;
		this.setConsumerId(consumerId);

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Complaint that = (Complaint) o;
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.intValue();

	}

	public Integer getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}
}
