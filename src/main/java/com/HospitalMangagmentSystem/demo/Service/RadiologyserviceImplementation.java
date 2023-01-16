package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.RadiologyDto;
import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import com.HospitalMangagmentSystem.demo.domain.Radiology;
import com.HospitalMangagmentSystem.demo.repository.RadiologyRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@JsonDeserialize
public class RadiologyserviceImplementation implements RadiologyService{


        @Autowired
        RadiologyRepository radrep;


        @Override
        public List<Radiology> getallRadiology() {
            // TODO Auto-generated method stub

            return this.radrep.findAll();
        }


        @Override
        public Radiology getoneRadiology(int id) {
            // TODO Auto-generated method stub
            Radiology rr=radrep.findById(id).orElseThrow(()->
                    new DataNotFoundException("Radiology with id " + id + " not found") );

            return rr;
        }

        @Override
        public List<Radiology> getoneRadiologyByVisit(String vid) {
            // TODO Auto-generated method stu
            return radrep.findByVisit(vid);
        }

        @Override
        public Radiology createRadiology(RadiologyDto raddto) {
            // TODO Auto-generated method stub
            Radiology rr = new Radiology();
            rr.setUrgency(raddto.getUrgency());
            rr.setFast(raddto.getFast());
            rr.setDate(raddto.getDate());
            rr.setTesttype(raddto.getTesttype());
            rr.setDrugtherapy(raddto.getDrugtherapy());
            rr.setLastdose(raddto.getLastdose());
            rr.setOtherinfo(raddto.getOtherinfo());
            rr.setProfiletest(raddto.getProfiletest());
            rr.setDiabetis(raddto.getDiabetis());
            rr.setMetformin(raddto.getMetformin());
            rr.setRenalFunction(raddto.getRenalFunction());
            rr.setWeight(raddto.getWeight());
            rr.setPreviousExam(raddto.getPreviousExam());
            rr.setReasonForScan(raddto.getReasonForScan());
            rr.setRelevantHistory(raddto.getRelevantHistory());
            rr.setRadiologistName(raddto.getRadiologistName());
            rr.setVid(raddto.getVid());
            rr.setUser(rr.getUser());
            rr.setPatient(rr.getPatient());
            //new;ly added
            rr.setExamRequested(raddto.getExamRequested());
            rr.setExamTypeDetail(raddto.getExamTypeDetail());
            rr.setClinicalData(raddto.getClinicalData());
            rr.setRequestedBy(raddto.getRequestedBy());
            rr.setReport(raddto.getReport());
            rr.setReportedBy(raddto.getReportedBy());
            rr.setFinished(false);
            return radrep.save(rr);
        }

        @Override
        public void deleteRadiology(int id) {
            radrep.deleteById(id);

        }

        @Override
        public Radiology ubdateRadiology(RadiologyDto raddto, int id) {
            // TODO Auto-generated method stub
            Radiology rr = new Radiology();
            rr=radrep.findById(id).orElseThrow(()->
                    new DataNotFoundException("Radiology with id " + id + " not found") );
            rr.setDate(raddto.getDate());
            rr.setReport(raddto.getReport());
            rr.setReportedBy(raddto.getReportedBy());
            rr.setFinished(true);
            return this.radrep.save(rr);
        }

    }




