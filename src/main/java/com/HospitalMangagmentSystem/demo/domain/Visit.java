package com.HospitalMangagmentSystem.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="visit")
@NamedQuery(name="Visit.findAll", query="SELECT v FROM Visit v")
public class Visit {
    @Id
    @Column(name="id")
    private String id;
    private String doctorName;
    private Date date;
    private String pid;
    private String conditions;
    private String cc;
    private String hpi;
    private String pastHistory;
    private String familyHistory;
    private String heent;
    private String lns;
    private String cvs;
    private String abdomen;
    private String gus;
    private String mss;
    private String cns;
    private String investigation;
    private String bp;
    private String pr;
    private String rr;
    private String temp;
    private String treatment;
    private String gHistory;
    private String medicalHistory;
    private String cMedication;
    private String allergies;
    private String ReviewOSystems;
    private String socialHistory;
    private String generalApperance;
    private String dx;
    private boolean finished;


    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getHpi() {
        return hpi;
    }

    public void setHpi(String hpi) {
        this.hpi = hpi;
    }

    public String getPastHistory() {
        return pastHistory;
    }

    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public String getHeent() {
        return heent;
    }

    public void setHeent(String heent) {
        this.heent = heent;
    }

    public String getLns() {
        return lns;
    }

    public void setLns(String lns) {
        this.lns = lns;
    }

    public String getCvs() {
        return cvs;
    }

    public void setCvs(String cvs) {
        this.cvs = cvs;
    }

    public String getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    public String getGus() {
        return gus;
    }

    public void setGus(String gus) {
        this.gus = gus;
    }

    public String getMss() {
        return mss;
    }

    public void setMss(String mss) {
        this.mss = mss;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getInvestigation() {
        return investigation;
    }

    public void setInvestigation(String investigation) {
        this.investigation = investigation;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public String getRr() {
        return rr;
    }

    public void setRr(String rr) {
        this.rr = rr;
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

    public String getgHistory() {
        return gHistory;
    }

    public void setgHistory(String gHistory) {
        this.gHistory = gHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getcMedication() {
        return cMedication;
    }

    public void setcMedication(String cMedication) {
        this.cMedication = cMedication;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getReviewOSystems() {
        return ReviewOSystems;
    }

    public void setReviewOSystems(String reviewOSystems) {
        ReviewOSystems = reviewOSystems;
    }

    public String getSocialHistory() {
        return socialHistory;
    }

    public void setSocialHistory(String socialHistory) {
        this.socialHistory = socialHistory;
    }

    public String getGeneralApperance() {
        return generalApperance;
    }

    public void setGeneralApperance(String generalApperance) {
        this.generalApperance = generalApperance;
    }

    public String getDx() {
        return dx;
    }

    public void setDx(String dx) {
        this.dx = dx;
    }
}
