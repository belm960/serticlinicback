package com.HospitalMangagmentSystem.demo.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class AppointementDto {
    private String firstname;
    private String lastname;
    private String gender;
    private String mobile;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    //@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
    private Date date;
    private String patientName;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    //@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
    private Date doa;

    private String toa;
    private String email;
    private String injury;
    private String note;


    private String doctorName;
    private String disease;
    private String status;
    private Date aDate;
    private String pid;
    private String patient;
    private String doctorid;


    public String getDoctorid() {
        return doctorid;
    }

    public Date getDate() {
        return date;
    }

    public String getPatient() {
        return patient;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDisease() {
        return disease;
    }

    public String getStatus() {
        return status;
    }

    public Date getaDate() {
        return aDate;
    }

    public String getPid() {
        return pid;
    }

    public String getEmail() {
        return email;
    }

    public String getfirstname() {
        return firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }





    public String getPatientName() {
        return patientName;
    }

    public String getInjury() {
        return injury;
    }

    public String getNote() {
        return note;
    }

    public String getToa() {
        return toa;
    }

    public Date getDoa() {
        return doa;
    }
}