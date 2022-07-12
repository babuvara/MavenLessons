package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "APPOINTMENTS")
public class Appointment {
	@Id
	@Column(name = "APP_ID")
	private int id;
	@Column(name = "APP_DATE")
	private Date appdate;
	@Column(name = "DOC_ID")
	private int docid;
	@Column(name = "PATIENT_NAME")
	private String patientname;
	@Column(name = "FEES_COLLECTED")
	private float feescollected;
	//for many instances of appointment object only one instances of doctors object
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "DOC_ID", nullable = false, insertable = false, updatable = false)
	private Doctor doctor;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int getAppid() {
		return id;
	}

	public void setAppid(int appid) {
		this.id = appid;
	}

	public Date getAppdate() {
		return appdate;
	}

	public void setAppdate(Date appdate) {
		this.appdate = appdate;
	}

//	public int getDocid() {
//		return docid;
//	}
//
//	public void setDocid(int docid) {
//		this.docid = docid;

	public String getPatname() {
		return patientname;
	}

	public void setPatname(String patientname) {
		this.patientname = patientname;
	}

	public float getFee() {
		return feescollected;
	}

	public void setFee(float fee) {
		this.feescollected = fee;
	}

	@Override
	public String toString() {
		return String.format("%d, %s %d, %s, %d", id, appdate, docid, patientname, feescollected);
	}

}
