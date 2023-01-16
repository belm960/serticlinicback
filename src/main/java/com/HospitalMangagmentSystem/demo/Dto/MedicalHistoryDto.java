package com.HospitalMangagmentSystem.demo.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MedicalHistoryDto {


    private String record_type;
    private String description;
    private String diagnosis_code;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date onset_date;

    private String diagnosis;

    private String diagnosisNotes;
    private String diseaseCatagory;

    public String getRecord_type() {
        return record_type;
    }

    public String getDescription() {
        return description;
    }

    public String getDiagnosis_code() {
        return diagnosis_code;
    }

    public Date getOnset_date() {
        return onset_date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getDiagnosisNotes() {
        return diagnosisNotes;
    }

    public String getDiseaseCatagory() {
        return diseaseCatagory;
    }
}
