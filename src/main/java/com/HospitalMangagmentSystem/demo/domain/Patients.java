package com.HospitalMangagmentSystem.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="patient")
@NamedQuery(name="Patients.findAll", query="SELECT a FROM Patients a")
public class Patients{
	@Id
	@GeneratedValue
	private int Patient_ID;

	private String first;
	private String last;
	private String gender;
	private String mobile;
	@Temporal(TemporalType.TIMESTAMP)
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
	private String roomNo;
	private int userid;
	private int doctorid;
	private String address;
	private String pStatus;

	public String getpStatus() {
		return pStatus;
	}

	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	//@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
	private Date sortDate;
	private String room;


	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public Date getSortDate() {
		return sortDate;
	}
	public void setSortDate(Date sortDate) {
		this.sortDate = sortDate;
	}
	public String getV() {
		return v;
	}
	public int getLab() {
		return lab;
	}
	public int getRad() {
		return rad;
	}
	public void setLab(int lab) {
		this.lab = lab;
	}
	public void setRad(int rad) {
		this.rad = rad;
	}
	public void setV(String v) {
		this.v = v;
	}
	public String getdType() {
		return dType;
	}
	public void setdType(String dType) {
		this.dType = dType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Patients() {
	}


	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL)
	@JsonIgnore
	public Set<Patientstreatments> getPatienttreatment() {
		return patienttreatment;
	}

	@OneToMany(mappedBy="patient",cascade = CascadeType.ALL)
//	@JsonBackReference 
	@JsonIgnore
	 private Set<DoctorsVisit> doctorsVisits;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="day_Date_Time")
	@JsonIgnore
	private Refcalendar day_Date_Time;
	
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="diease_Code")
	//@JsonManagedReference
	@JsonIgnore
	private Refdiseases Disease;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Public_or_Private_Insurance_Code")
	//@JsonManagedReference
	@JsonIgnore
	private Publicorprivateinsurance Public_or_Private_Insurance_Code;
/**
	// bi-directional many-to-one association to PatientAddress
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patient")
	@JsonManagedReference
	private Set<Address> address;
**/

	@OneToMany(mappedBy="patient",  cascade = CascadeType.ALL)
	@JsonIgnore
	 //@JsonManagedReference
	private Set<Patientstreatments> patienttreatment;

	// bi-directional many-to-one association to PatientAddress
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "patients")
	@JsonManagedReference
	private Set<Orders> orders;

	@OneToMany(mappedBy="patient",  cascade = CascadeType.ALL)
	@JsonIgnore
	//@JsonManagedReference
	private Set<Radiology> radiology;
	// bi-directional many-to-one association to Encounter
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patient")
	@JsonIgnore
	private Set<MedicalHistory> medicalhistory;

	@OneToMany(mappedBy="patient",  cascade = CascadeType.ALL)
	@JsonIgnore
	//@JsonManagedReference
	private Set<MedicalHistory> medicalHistory;

	@OneToMany(mappedBy="patient",  cascade = CascadeType.ALL)
	@JsonIgnore
	//@JsonManagedReference
	private Set<Appointement> appointment;


	// bi-directional many-to-one association to PatientAddress
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "patient")
	@JsonManagedReference
	private Set<Laboratory> laboratory;

	public int getPatient_ID() {
		return Patient_ID;
	}

	public void setPatient_ID(int patient_ID) {
		Patient_ID = patient_ID;
	}




	public Refdiseases getDisease() {
		return Disease;
	}

	public void setDisease(Refdiseases disease) {
		Disease = disease;
	}

	



	public void setPatienttreatment(Set<Patientstreatments> patienttreatment) {
		this.patienttreatment = patienttreatment;
	}



	

	public Refcalendar getDay_Date_Time() {
		return day_Date_Time;
	}
	public void setDay_Date_Time(Refcalendar day_Date_Time) {
		this.day_Date_Time = day_Date_Time;
	}
	public Publicorprivateinsurance getPublic_or_Private_Insurance_Code() {
		return Public_or_Private_Insurance_Code;
	}
	public void setPublic_or_Private_Insurance_Code(Publicorprivateinsurance public_or_Private_Insurance_Code) {
		Public_or_Private_Insurance_Code = public_or_Private_Insurance_Code;
	}
/**
	public Set<Address> getAddress() {
		return address;
	}

	public Address addPatientAddress(Address patientAddress) {
		if (address == null) {
			address = new HashSet<Address>();
		}
		getAddress().add(patientAddress);
		patientAddress.setPatient(this);

		return patientAddress;
	}

**/
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



/**
	public void setAddress(Set<Address> address) {
		this.address = address;
	}**/



	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	public Set<Radiology> getRadiology() {
		return radiology;
	}
	public void setRadiology(Set<Radiology> radiology) {
		this.radiology = radiology;
	}



	public void setAppointment(Set<Appointement> appointment) {
		this.appointment = appointment;
	}

	public Set<Laboratory> getLaboratory() {
		return laboratory;
	}

	public void setLaboratory(Set<Laboratory> laboratory) {
		this.laboratory = laboratory;
	}

	public Set<DoctorsVisit> getDoctorsVisits() {
		return doctorsVisits;
	}

	public void setDoctorsVisits(Set<DoctorsVisit> doctorsVisits) {
		this.doctorsVisits = doctorsVisits;
	}
	public DoctorsVisit addEncounter(DoctorsVisit encounter) {
		if(doctorsVisits == null) {
			doctorsVisits = new HashSet<DoctorsVisit>();
		}
		getDoctorsVisits().add(encounter);
		encounter.setPatient(this);

		return encounter;
	}

	public MedicalHistory addMedicalHistory(MedicalHistory history) {
		if(medicalhistory == null) {
			medicalhistory = new HashSet<MedicalHistory>();
		}
		getMedicalhistory().add(history);
		history.setPatient(this);

		return history;
	}

	public Set<MedicalHistory> getMedicalhistory() {
		return medicalhistory;
	}

	public void setMedicalhistory(Set<MedicalHistory> medicalhistory) {
		this.medicalhistory = medicalhistory;
	}

	public Set<MedicalHistory> getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(Set<MedicalHistory> medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public Set<Appointement> getAppointment() {
		return appointment;
	}
}