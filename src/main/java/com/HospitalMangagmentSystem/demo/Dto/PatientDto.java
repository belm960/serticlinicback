package com.HospitalMangagmentSystem.demo.Dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class PatientDto {

	private String first;
	private String last;
	private String gender;
	private String mobile;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	//@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
	private Date dob;
	private int age;
	private String email;
	private String status;
	private String dType;
	private String v;
	private int lab;
	private int rad;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	//@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
	private Date sortDate;
	private String address;
	private String roomNo;
	private String room;
	private int userid;
	private int doctorid;
	private String pStatus;


	public String getpStatus() {
		return pStatus;
	}

	public int getDoctorid() {
		return doctorid;
	}

	public int getUserid() {
		return userid;
	}

	public String getRoom() {
		return room;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public Date getSortDate() {
		return sortDate;
	}

	public int getLab() {
		return lab;
	}

	public int getRad() {
		return rad;
	}

	public String getV() {
		return v;
	}

	public String getdType() {
		return dType;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public String getGender() {
		return gender;
	}

	public String getMobile() {
		return mobile;
	}

	public Date getDob() {
		return dob;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		return status;
	}

	public String getAddress() {
		return address;
	}
}
