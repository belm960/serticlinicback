package com.HospitalMangagmentSystem.demo.domain;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;


/**
 * The persistent class for the doctors_visits database table.
 * 
 */
@Entity
@Table(name="doctors_visits")
@NamedQuery(name="DoctorsVisit.findAll", query="SELECT d FROM DoctorsVisit d")
public class DoctorsVisit extends AuditModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
    private String title;
	private Date visitDate;
	private String doctorName;
	private String note_Details;
	private String labDiagnosis;
	private  String radDiagnosis;
	private int pid;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getNote_Details() {
		return note_Details;
	}

	public void setNote_Details(String note_Details) {
		this.note_Details = note_Details;
	}

	public String getLabDiagnosis() {
		return labDiagnosis;
	}

	public void setLabDiagnosis(String labDiagnosis) {
		this.labDiagnosis = labDiagnosis;
	}

	public String getRadDiagnosis() {
		return radDiagnosis;
	}

	public void setRadDiagnosis(String radDiagnosis) {
		this.radDiagnosis = radDiagnosis;
	}

	private String bp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CHECK_IN_DATE_TIME")
	private Date checkInDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CHECK_OUT_DATE_TIME")
	private Date checkOutDateTime;

	@Column(name = "CHIEF_COMPLAINT")
	private String chiefComplaint;

	private String diagnosis;

	private String pulse;

	private String remark;

	@Column(name = "RESP_RATE")
	private String respRate;

	private String rflu;

	@Column(name = "ROOM_NBR")
	private int roomNbr;

	private String rs;

	private String rsv;

	private String sat;

	private String status;

	private String temp;

	private String treatment;

	private String ua;

	private String weight;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	//@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
	private Date servicedate;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	//@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
	private Date Nextservicedate;





	private String visit_Details;



	//bi-directional many-to-one association to RefCalender
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="Day_Date_Time")
	@JsonIgnoreProperties({"hiber nateLazyInitializer", "handler"})
	//@JsonManagedReference
	private Refcalendar refCalender;

	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "DOCTOR_ID", referencedColumnName = "id")
	@JsonManagedReference
	private User doctor;

	@ManyToOne
	@JoinColumn(name = "PATIENT_ID", referencedColumnName = "Patient_ID")
	private Patients patient;





	public DoctorsVisit() {
	}







	public String getVisit_Details() {
		return this.visit_Details;
	}

	public void setVisit_Details(String visit_Details) {
		this.visit_Details = visit_Details;
	}

	public Refcalendar getRefCalender() {
		return this.refCalender;
	}

	public void setRefCalender(Refcalendar refCalender) {
		this.refCalender = refCalender;
	}



	public Patients getPatient() {
		return this.patient;
	}

	public void setPatient(Patients patient) {
		this.patient = patient;
	}




	public Date getServicedate() {
		return servicedate;
	}

	public void setServicedate(Date servicedate) {
		this.servicedate = servicedate;
	}

	public Date getNextservicedate() {
		return Nextservicedate;
	}

	public void setNextservicedate(Date nextservicedate) {
		Nextservicedate = nextservicedate;
	}



	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public Date getCheckInDateTime() {
		return checkInDateTime;
	}

	public void setCheckInDateTime(Date checkInDateTime) {
		this.checkInDateTime = checkInDateTime;
	}

	public Date getCheckOutDateTime() {
		return checkOutDateTime;
	}

	public void setCheckOutDateTime(Date checkOutDateTime) {
		this.checkOutDateTime = checkOutDateTime;
	}

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getPulse() {
		return pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRespRate() {
		return respRate;
	}

	public void setRespRate(String respRate) {
		this.respRate = respRate;
	}

	public String getRflu() {
		return rflu;
	}

	public void setRflu(String rflu) {
		this.rflu = rflu;
	}

	public int getRoomNbr() {
		return roomNbr;
	}

	public void setRoomNbr(int roomNbr) {
		this.roomNbr = roomNbr;
	}

	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	public String getRsv() {
		return rsv;
	}

	public void setRsv(String rsv) {
		this.rsv = rsv;
	}

	public String getSat() {
		return sat;
	}

	public void setSat(String sat) {
		this.sat = sat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getUa() {
		return ua;
	}

	public void setUa(String ua) {
		this.ua = ua;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}


	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}
}