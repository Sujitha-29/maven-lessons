package com.chainsys.mavenlessons.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Appointment")
public class Appointment {
	@Id
	@Column(name="APP_ID")
	private int id;
	@Column(name="APP_DATE ")
	private Date appointDate;
	@Column(name="DOC_ID")
	private int dr_id;
	// Join column maps the column(doc_id) of the current Entity Appointment
	// with the Primarykey column(id) of the associated Entity Doctor
	
	@Column(name="PATIENT_NAME")
	private String patName;
	@Column(name="FEES_COLLECTED")
	private float fees;
	@Column(name="FEES_NATURE")
	private String fees_type;
	// for many instances of appointments only one instance of doctor object
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="doc_id" , nullable = false,insertable = false,updatable = false)
	@JsonIgnore
	private Doctor doctor;
	public Doctor getDoctor()
	{
		return this.doctor;
	}
	public void setDoctor( Doctor doc)
	{
		this.doctor=doc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getAppointDate() {
		return appointDate;
	}
	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}
	public int getDr_id() {
		return dr_id;
	}
	public void setDr_id(int dr_id) {
		this.dr_id = dr_id;
	}
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	public String getFees_type() {
		return fees_type;
	}
	public void setFees_type(String fees_type) {
		this.fees_type = fees_type;
	}
	@Override
	public String toString()
	{
		return String.format("%d, %s,%d, %s, %.2f, %s" , id,appointDate,dr_id,patName,fees,fees_type);
	}
		
}
  

