package com.HospitalMangagmentSystem.demo.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class RoomDto {
    private String pid;
    private String pName;
    private String pSex;
    private String roomNo;
    private String roomType;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    //@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
    private Date admitDate;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
    //@JsonFormat(pattern = "MM/dd/yyyy", timezone = "America/New_York")
    private Date dischargeDate;

    public String getPid() {
        return pid;
    }

    public String getpName() {
        return pName;
    }

    public String getpSex() {
        return pSex;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public Date getAdmitDate() {
        return admitDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }


}
