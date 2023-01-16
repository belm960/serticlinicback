package com.HospitalMangagmentSystem.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="appointement")
@NamedQuery(name="Appointement.findAll", query="SELECT a FROM Appointement a")
public class Appointement extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String gender;
    private String mobile;
    private String doctorName;
    private String disease;
    private String status;
    private Date aDate;
    private String pid;
    private String doctorid;

    @OneToOne
    private Patients patient;

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getaDate() {
        return aDate;
    }

    public void setaDate(Date aDate) {
        this.aDate = aDate;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public Patients getPatient() {
        return patient;
    }

    @Size(max = 50)
    @Email
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    //@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
    private Date date;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    //@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
    private Date dateofappointment;

    private String timeofappointment;
    private String injury;
    private String notes;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="User_id")
    @JsonManagedReference
    @JsonIgnore
    private User doctor;


    private String patientName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateofappointment() {
        return dateofappointment;
    }

    public void setDateofappointment(Date dateofappointment) {
        this.dateofappointment = dateofappointment;
    }





    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public String getTimeofappointment() {
        return timeofappointment;
    }

    public void setTimeofappointment(String timeofappointment) {
        this.timeofappointment = timeofappointment;
    }

    public String getInjury() {
        return injury;
    }

    public void setInjury(String injury) {
        this.injury = injury;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
