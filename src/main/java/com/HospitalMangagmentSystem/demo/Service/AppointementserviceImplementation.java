package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.AppointementDto;
import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import com.HospitalMangagmentSystem.demo.domain.Appointement;
import com.HospitalMangagmentSystem.demo.repository.UserRepository;
import com.HospitalMangagmentSystem.demo.repository.appointementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AppointementserviceImplementation implements AppointementService{
    @Autowired
    appointementRepository apprep;
    @Autowired
    UserRepository userRepo;

    @Override
    public List<Appointement> getallappointement() {
        return apprep.findAll();
    }
    @Override
    public List<Appointement> getAppByPAndS(String pid,String status){
        return apprep.findByIdAndStatus(pid,status);
    }
    @Override
    public List<Appointement> getAppByPid(String pid){
        return apprep.findByPatientId(pid);
    }
    @Override
    public List<Appointement> getByDoctorid(String doctorid){
        return apprep.findByDoctorid(doctorid);
    }
    @Override
    @Transactional
    public Appointement createAppointement(AppointementDto appd) {
        Appointement app = new Appointement();
         app.setPatientName(appd.getPatientName());
         app.setDisease(appd.getDisease());
         app.setDate(appd.getDate());
         app.setMobile(appd.getMobile());
         app.setEmail(appd.getEmail());
         app.setStatus(appd.getStatus());
         app.setPid(appd.getPid());
         app.setDoctorid(appd.getDoctorid());
        return apprep.save(app);
    }
    @Override
    public void deleteAppointement(int id) {
        Appointement app = apprep.findById(id).orElseThrow(()->
                new DataNotFoundException("appointement with id " + id + " not found") );
        apprep.delete(app);

    }
    @Override
    public Appointement ubdateAppointement(AppointementDto appd, int id) {
        Appointement app = apprep.findById(id).orElseThrow(()->
                new DataNotFoundException("appointement with id " + id + " not found") );
        app.setFirstname(appd.getfirstname());
        app.setLastname(appd.getlastname());
        app.setEmail(appd.getEmail());
        app.setDateofappointment(appd.getDoa());
        app.setTimeofappointment(appd.getToa());
        app.setInjury(appd.getInjury());
        app.setNotes(appd.getNote());
        app.setPatientName(appd.getPatient());
        return apprep.save(app);

    }
    @Override
    public Appointement ubdateAppointementStatus(AppointementDto appd, int id) {
        Appointement app = apprep.findById(id).orElseThrow(()->
                new DataNotFoundException("appointement with id " + id + " not found") );
        app.setStatus(appd.getStatus());
        return apprep.save(app);

    }
}
