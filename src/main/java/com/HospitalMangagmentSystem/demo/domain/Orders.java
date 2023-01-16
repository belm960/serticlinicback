package com.HospitalMangagmentSystem.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orders")
@NamedQuery(name="Orders.findAll", query="SELECT o FROM Orders o")
public class Orders extends AuditModel{
        @Id
        @GeneratedValue
        private int order_ID;
        private String drug;
            @Temporal(TemporalType.TIMESTAMP)
            @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
        private Date orderDate;
        private String discontinued;
        private String refill;
        private String recordType;
        private String dosage;
        private String route;
        private String frequency;
        private String duration;
        private String dispense;
        private String reasonForPrescription;
        private String orderNote;


    @ManyToOne
    @JoinColumn(name="Patient_ID")
    @JsonBackReference
    @JsonIgnore
    private Patients patients;


    public int getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(int order_ID) {
        this.order_ID = order_ID;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(String discontinued) {
        this.discontinued = discontinued;
    }

    public String getRefill() {
        return refill;
    }

    public void setRefill(String refill) {
        this.refill = refill;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDispense() {
        return dispense;
    }

    public void setDispense(String dispense) {
        this.dispense = dispense;
    }

    public String getReasonForPrescription() {
        return reasonForPrescription;
    }

    public void setReasonForPrescription(String reasonForPrescription) {
        this.reasonForPrescription = reasonForPrescription;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }


    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }
}
