package com.HospitalMangagmentSystem.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientsPayment {
     private int payment_id;
     private String first;
     private String last;
     private double cost;
     private Date date;
     private String title;
     private int pid;
     private String vid;
     private String status;
     private String address;


}
