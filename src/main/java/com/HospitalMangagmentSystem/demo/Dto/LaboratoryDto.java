package com.HospitalMangagmentSystem.demo.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class LaboratoryDto {

    private String first;
    private String last;
    private String firstt;
    private String lastt;
    private String urgency;
    private String fast;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    //@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
    private Date date;
    private String testtype;
    private String drugtherapy;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    //@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
    private String lastdose;
    private String otherinfo;
    private String profiletest;
    private String biochem;
    private String hematology;
    private String microbio;
    private String anatomicalpathology;
    private String laboratoristName;



    private String vid;
    private String test;
    private String result;
    private String unit;
    private String reference;
    //sst- specimenType
    private String sst;
    private String departmentName;
    private String nameOfVerifier;
    private Date receivedDate;
    private Date reportedTime;
    private Date verificationDate;
    private String requestedBy;
    private boolean status;


    public boolean isStatus() {
        return status;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public String getTest() {
        return test;
    }

    public String getResult() {
        return result;
    }

    public String getUnit() {
        return unit;
    }

    public String getReference() {
        return reference;
    }

    public String getSst() {
        return sst;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getNameOfVerifier() {
        return nameOfVerifier;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public Date getReportedTime() {
        return reportedTime;
    }

    public Date getVerificationDate() {
        return verificationDate;
    }

    public String getVid() {
        return vid;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getFirstt() {
        return firstt;
    }

    public String getLastt() {
        return lastt;
    }

    public String getUrgency() {
        return urgency;
    }

    public String getFast() {
        return fast;
    }

    public Date getDate() {
        return date;
    }

    public String getTesttype() {
        return testtype;
    }

    public String getDrugtherapy() {
        return drugtherapy;
    }

    public String getLastdose() {
        return lastdose;
    }

    public String getOtherinfo() {
        return otherinfo;
    }

    public String getProfiletest() {
        return profiletest;
    }

    public String getBiochem() {
        return biochem;
    }

    public String getHematology() {
        return hematology;
    }

    public String getMicrobio() {
        return microbio;
    }

    public String getAnatomicalpathology() {
        return anatomicalpathology;
    }

    public String getLaboratoristName() {
        return laboratoristName;
    }
}
