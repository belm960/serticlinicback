package com.HospitalMangagmentSystem.demo.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class OrderDto {
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

    public String getDrug() {
        return drug;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getDiscontinued() {
        return discontinued;
    }

    public String getRefill() {
        return refill;
    }

    public String getRecordType() {
        return recordType;
    }

    public String getDosage() {
        return dosage;
    }

    public String getRoute() {
        return route;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getDuration() {
        return duration;
    }

    public String getDispense() {
        return dispense;
    }

    public String getReasonForPrescription() {
        return reasonForPrescription;
    }

    public String getOrderNote() {
        return orderNote;
    }
}
