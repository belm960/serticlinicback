package com.HospitalMangagmentSystem.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="laboratory")
@NamedQuery(name="Laboratory.findAll", query="SELECT l FROM Laboratory l")
public class Laboratory extends AuditModel{
    @Id
    @GeneratedValue
    private int labid;
    private String urgency;
    private String fast;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    //@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
    private Date date;

    private String testtype;

    private String drugtherapy;




    private String lastdose;

    private String otherinfo;

    private String profiletest;

    private String biochem;

    private String hematology;

    private String microbio;

    private String anatomicalpathology;

    private String laboratoristName;

    private String vid;


    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    //bi-directional many-to-one association to Doctor
    @ManyToOne(fetch=FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name="User_ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@JsonIgnore
    private User user;

    //bi-directional many-to-one association to Patient
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="Patient_ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Patients patient;


    //NEWLY ADDED attributes
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

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSst() {
        return sst;
    }

    public void setSst(String sst) {
        this.sst = sst;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getNameOfVerifier() {
        return nameOfVerifier;
    }

    public void setNameOfVerifier(String nameOfVerifier) {
        this.nameOfVerifier = nameOfVerifier;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getReportedTime() {
        return reportedTime;
    }

    public void setReportedTime(Date reportedTime) {
        this.reportedTime = reportedTime;
    }

    public Date getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(Date verificationDate) {
        this.verificationDate = verificationDate;
    }

    public int getLabid() {
        return labid;
    }

    public void setLabid(int labid) {
        this.labid = labid;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getFast() {
        return fast;
    }

    public void setFast(String fast) {
        this.fast = fast;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTesttype() {
        return testtype;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype;
    }

    public String getDrugtherapy() {
        return drugtherapy;
    }

    public void setDrugtherapy(String drugtherapy) {
        this.drugtherapy = drugtherapy;
    }

    public String getLastdose() {
        return lastdose;
    }

    public void setLastdose(String lastdose) {
        this.lastdose = lastdose;
    }

    public String getOtherinfo() {
        return otherinfo;
    }

    public void setOtherinfo(String otherinfo) {
        this.otherinfo = otherinfo;
    }

    public String getProfiletest() {
        return profiletest;
    }

    public void setProfiletest(String profiletest) {
        this.profiletest = profiletest;
    }

    public String getBiochem() {
        return biochem;
    }

    public void setBiochem(String biochem) {
        this.biochem = biochem;
    }

    public String getHematology() {
        return hematology;
    }

    public void setHematology(String hematology) {
        this.hematology = hematology;
    }

    public String getMicrobio() {
        return microbio;
    }

    public void setMicrobio(String microbio) {
        this.microbio = microbio;
    }

    public String getAnatomicalpathology() {
        return anatomicalpathology;
    }

    public void setAnatomicalpathology(String anatomicalpathology) {
        this.anatomicalpathology = anatomicalpathology;
    }

    public String getLaboratoristName() {
        return laboratoristName;
    }

    public void setLaboratoristName(String laboratoristName) {
        this.laboratoristName = laboratoristName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

  public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }
}
