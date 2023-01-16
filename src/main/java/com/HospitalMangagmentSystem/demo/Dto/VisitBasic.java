package com.HospitalMangagmentSystem.demo.Dto;

public class VisitBasic {
    String encounterId;
    String roomNbr;
    String pulse;
    String temp;
    String sat;
    String respRate;
    String weight;

    public String getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(String encounterId) {
        this.encounterId = encounterId;
    }

    public String getRoomNbr() {
        return roomNbr;
    }

    public void setRoomNbr(String roomNbr) {
        this.roomNbr = roomNbr;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public String getRespRate() {
        return respRate;
    }

    public void setRespRate(String respRate) {
        this.respRate = respRate;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
