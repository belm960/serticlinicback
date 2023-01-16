package com.HospitalMangagmentSystem.demo.Service;
import com.HospitalMangagmentSystem.demo.Dto.LaboratoryDto;
import com.HospitalMangagmentSystem.demo.domain.Laboratory;
import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;

import com.HospitalMangagmentSystem.demo.repository.LaboratoryRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@JsonDeserialize
public class LaboratoryServiceImplementation  implements LaboratoryService{

    @Autowired
    LaboratoryRepository labrep;

    @Override
    public List<Laboratory> getallLaboratories() {
        // TODO Auto-generated method stub

        return this.labrep.findAll();
    }

    @Override
    public Laboratory getonelaboratory(int id) {
        // TODO Auto-generated method stub
        Laboratory ll=labrep.findById(id).orElseThrow(()->
                new DataNotFoundException("Laboratory with id " + id + " not found") );

        return ll;
    }

    @Override
    public List<Laboratory> getoneLaboratoryByVisit(String vid) {
        // TODO Auto-generated method stu
        return labrep.findByVisit(vid);
    }

    @Override
    public Laboratory createLaboratory(LaboratoryDto labdto) {
        // TODO Auto-generated method stub
        Laboratory ll = new Laboratory();
        ll.setUrgency(labdto.getUrgency());
        ll.setFast(labdto.getFast());
        ll.setDate(labdto.getDate());
        ll.setTesttype(labdto.getTesttype());
        ll.setDrugtherapy(labdto.getDrugtherapy());
        ll.setLastdose(labdto.getLastdose());
        ll.setOtherinfo(labdto.getOtherinfo());
        ll.setProfiletest(labdto.getProfiletest());
        ll.setBiochem(labdto.getBiochem());
        ll.setHematology(labdto.getHematology());
        ll.setMicrobio(labdto.getMicrobio());
        ll.setAnatomicalpathology(labdto.getAnatomicalpathology());
        ll.setLaboratoristName(labdto.getLaboratoristName());
        ll.setVid(labdto.getVid());
        ll.setUser(ll.getUser());
        //new added
        ll.setTest(labdto.getTest());
        ll.setResult(labdto.getResult());
        ll.setUnit(labdto.getUnit());
        ll.setReference(labdto.getReference());
        ll.setSst(labdto.getSst());
        ll.setDepartmentName(labdto.getDepartmentName());
        ll.setNameOfVerifier(labdto.getNameOfVerifier());
        ll.setReceivedDate(labdto.getReceivedDate());
        ll.setReportedTime(labdto.getReportedTime());
        ll.setVerificationDate(labdto.getVerificationDate());
        ll.setRequestedBy(labdto.getRequestedBy());
        ll.setStatus(false);
      // ll.setPatient(ll.getPatient());

        return labrep.save(ll);
    }

    @Override
    public void deleteLaboratory(int id) {
        labrep.deleteById(id);

    }

    @Override
    public Laboratory ubdateLaboratory(LaboratoryDto labdto, int id) {
        // TODO Auto-generated method stub
        Laboratory ll=labrep.findById(id).orElseThrow(()->
                new DataNotFoundException("Laboratory with id " + id + " not found") );

        ll.setUrgency(labdto.getUrgency());
        ll.setFast(labdto.getFast());
        ll.setDate(labdto.getDate());
        ll.setTesttype(labdto.getTesttype());
        ll.setDrugtherapy(labdto.getDrugtherapy());
        ll.setLastdose(labdto.getLastdose());
        ll.setOtherinfo(labdto.getOtherinfo());
        ll.setProfiletest(labdto.getProfiletest());
        ll.setBiochem(labdto.getBiochem());
        ll.setHematology(labdto.getHematology());
        ll.setMicrobio(labdto.getMicrobio());
        ll.setAnatomicalpathology(labdto.getAnatomicalpathology());
        ll.setLaboratoristName(labdto.getLaboratoristName());
        ll.setUser(ll.getUser());
       // ll.setPatient(ll.getPatient());
        //newly added
        ll.setResult(labdto.getResult());
        ll.setUnit(labdto.getUnit());
        ll.setReference(labdto.getReference());
        ll.setSst(labdto.getSst());
        ll.setDepartmentName(labdto.getDepartmentName());
        ll.setNameOfVerifier(labdto.getNameOfVerifier());
        ll.setReportedTime(labdto.getReportedTime());
        ll.setVerificationDate(labdto.getVerificationDate());
        ll.setStatus(true);
        return this.labrep.save(ll);
    }

}