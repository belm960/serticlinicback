package com.HospitalMangagmentSystem.demo.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class RadiologyDto {

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
    private Date lastdose;

    private String otherinfo;
    private String profiletest;


    private String diabetis;
    private String metformin;

    private String renalFunction;

    private String weight;

    private String previousExam;
    private String reasonForScan;

    private String relevantHistory;

    private String radiologistName;


    private String vid;
    private String examRequested;
    //detail note about the request;
    private String examTypeDetail;
    // the data the doctor send to the rad room for the radiologist know hoe to do some things or some protection
    private String clinicalData;
    private String requestedBy;
    private String report;
    private String reportedBy;
    private boolean finished;

    public boolean isFinished() {
        return finished;
    }

    public String getExamRequested() {
        return examRequested;
    }

    public String getExamTypeDetail() {
        return examTypeDetail;
    }

    public String getClinicalData() {
        return clinicalData;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public String getReport() {
        return report;
    }

    public String getReportedBy() {
        return reportedBy;
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

    public Date getLastdose() {
        return lastdose;
    }

    public String getOtherinfo() {
        return otherinfo;
    }

    public String getProfiletest() {
        return profiletest;
    }

    public String getDiabetis() {
        return diabetis;
    }

    public String getMetformin() {
        return metformin;
    }

    public String getRenalFunction() {
        return renalFunction;
    }

    public String getWeight() {
        return weight;
    }

    public String getPreviousExam() {
        return previousExam;
    }

    public String getReasonForScan() {
        return reasonForScan;
    }

    public String getRelevantHistory() {
        return relevantHistory;
    }

    public String getRadiologistName() {
        return radiologistName;
    }
}
