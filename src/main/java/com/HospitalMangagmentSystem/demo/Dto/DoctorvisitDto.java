package com.HospitalMangagmentSystem.demo.Dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DoctorvisitDto {
    private int id;
	private String title;
	private Date visitDate;
	private String doctorName;
	private String note_Details;
	private String labDiagnosis;
	private  String radDiagnosis;
	private int pid;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	//@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
	private Date servicedate;
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	//@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
	private Date Nextservicedate;
	private String visitdetails;
	private String doctordetails;
	private String name ;
	private String department;
	private int age;
	@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
	private Date dateofbirth;
	private String patientname;
	private String otherdetails;
	@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
	private Date daydatetime;
	private int daynumber;


	public int getPid() {
		return pid;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public String getNote_Details() {
		return note_Details;
	}

	public String getLabDiagnosis() {
		return labDiagnosis;
	}

	public String getRadDiagnosis() {
		return radDiagnosis;
	}


	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getPatientname() {
		return patientname;
	}

	public String getVisitdetails() {
		return visitdetails;
	}


	public String getDoctordetails() {
		return doctordetails;
	}


	public Date getDateofbirth() {
		return dateofbirth;
	}


	public String getOtherdetails() {
		return otherdetails;
	}


	public Date getDaydatetime() {
		return daydatetime;
	}


	public int getDaynumber() {
		return daynumber;
	}


	public Date getServicedate() {
		return servicedate;
	}

	public Date getNextservicedate() {
		return Nextservicedate;
	}

	public int getAge() {
		return age;
	}
}
