package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.VisitDto;
import com.HospitalMangagmentSystem.demo.domain.Visit;
import com.HospitalMangagmentSystem.demo.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VisitServiceImplementation implements VisitService {
    @Autowired
    VisitRepository visrep;

    @Override
    public List<Visit> getbypid(String pid){
        return visrep.findByName(pid);
    }

    @Override
    public Visit getonevisit(String id){
        return visrep.findById(id).orElse(null);
    }

    @Override
    public Visit createvisit(VisitDto vis){
        Visit visit = new Visit();
        visit.setId(vis.getId());
        visit.setDoctorName(vis.getDoctorName());
        visit.setDate(vis.getDate());
        visit.setPid(vis.getPid());
        visit.setCc(vis.getCc());
        visit.setHpi(vis.getHpi());
        visit.setPastHistory(vis.getPastHistory());
        visit.setFamilyHistory(vis.getFamilyHistory());
        visit.setHeent(vis.getHeent());
        visit.setLns(vis.getLns());
        visit.setCvs(vis.getCvs());
        visit.setAbdomen(vis.getAbdomen());
        visit.setGus(vis.getGus());
        visit.setMss(vis.getMss());
        visit.setCns(vis.getCns());
        visit.setInvestigation(vis.getInvestigation());
        visit.setBp(vis.getBp());
        visit.setPr(vis.getPr());
        visit.setRr(vis.getRr());
        visit.setTemp(vis.getTemp());
        visit.setTreatment(vis.getTreatment());
        visit.setgHistory(vis.getgHistory());
        visit.setMedicalHistory(vis.getMedicalHistory());
        visit.setcMedication(vis.getcMedication());
        visit.setAllergies(vis.getAllergies());
        visit.setSocialHistory(vis.getSocialHistory());
        visit.setReviewOSystems(vis.getReviewOSystems());
        visit.setGeneralApperance(vis.getGeneralApperance());
        visit.setDx(vis.getDx());
        visit.setFinished(false);
        return visrep.save(visit);
    }

    @Override
    public void deletevisit(String id){
        visrep.deleteById(id);
    }

    @Override
    public Visit updatevisit(VisitDto vis , String id){
        Visit visit = visrep.findById(id).orElse(null);

        visit.setInvestigation(vis.getInvestigation());
        visit.setTreatment(vis.getTreatment());
        visit.setcMedication(vis.getcMedication());
        visit.setDx(vis.getDx());
        visit.setFinished(true);

       return visrep.save(visit);
   }
}
