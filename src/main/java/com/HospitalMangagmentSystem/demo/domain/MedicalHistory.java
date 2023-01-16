package com.HospitalMangagmentSystem.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Medical_History")
@NamedQuery(name="MedicalHistory.findAll", query="SELECT mh FROM MedicalHistory  mh")
public class MedicalHistory extends AuditModel{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;

    private String record_type;

    private String description;

    private String diagnosis_code;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")

    private Date onset_date;
    private String diagnosis;
    private String diagnosisNotes;
    private String diseaseCatagory;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="User_ID")
    //@JsonManagedReference
    @JsonIgnore
    private User user;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="Patient_ID")
    //@JsonManagedReference
    @JsonIgnore
    private Patients patient;




    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecord_type() {
        return record_type;
    }

    public void setRecord_type(String record_type) {
        this.record_type = record_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiagnosis_code() {
        return diagnosis_code;
    }

    public void setDiagnosis_code(String diagnosis_code) {
        this.diagnosis_code = diagnosis_code;
    }

    public Date getOnset_date() {
        return onset_date;
    }

    public void setOnset_date(Date onset_date) {
        this.onset_date = onset_date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }


    public String getDiagnosisNotes() {
        return diagnosisNotes;
    }

    public void setDiagnosisNotes(String diagnosisNotes) {
        this.diagnosisNotes = diagnosisNotes;
    }

    public String getDiseaseCatagory() {
        return diseaseCatagory;
    }

    public void setDiseaseCatagory(String diseaseCatagory) {
        this.diseaseCatagory = diseaseCatagory;
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
