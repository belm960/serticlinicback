package com.HospitalMangagmentSystem.demo.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class StaffDto {

    private String address;
    //private String conformPassword;
    private String department;
    private String designation;
    private String dob;
    private String first;
    private String gender;
    private String last;
    private String mobile;

    @Size(max = 50)
    @Email
    private String email;
    private String education;


    public String getAddress() {
        return address;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDob() {
        return dob;
    }

    public String getFirst() {
        return first;
    }

    public String getGender() {
        return gender;
    }

    public String getLast() {
        return last;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getEducation() {
        return education;
    }
}
