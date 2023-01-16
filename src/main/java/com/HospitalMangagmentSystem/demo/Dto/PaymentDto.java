package com.HospitalMangagmentSystem.demo.Dto;


import com.HospitalMangagmentSystem.demo.domain.Patients;
import com.HospitalMangagmentSystem.demo.domain.Visit;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class PaymentDto {
    private double cost;
    private double total;
    private String title;
    private Date date;
    private int  pid;
    private String vid;
    private String status;

    public String getStatus() {
        return status;
    }

    public double getCost() {
        return cost;
    }

    public double getTotal() {
        return total;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public int getPid() {
        return pid;
    }

    public String getVid() {
        return vid;
    }
}


