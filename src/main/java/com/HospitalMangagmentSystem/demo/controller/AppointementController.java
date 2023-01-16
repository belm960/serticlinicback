package com.HospitalMangagmentSystem.demo.controller;

import com.HospitalMangagmentSystem.demo.Dto.AppointementDto;
import com.HospitalMangagmentSystem.demo.Service.AppointementService;
import com.HospitalMangagmentSystem.demo.domain.Appointement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AppointementController {

    @Autowired
    AppointementService appsrvice ;
    @GetMapping("/appointement")
    public List<Appointement> getAppointment(){

        return this.appsrvice.getallappointement();
    }
    @GetMapping("/appointement/{pid}/PS/{status}")
    public List<Appointement> getAppByPAndS(@PathVariable String pid, @PathVariable String status){
        return this.appsrvice.getAppByPAndS(pid,status);
    }
    @GetMapping("/appointement/{pid}")
    public List<Appointement> getAppByPid(@PathVariable String pid){
        return this.appsrvice.getAppByPid(pid);
    }

    @GetMapping("/appointment/{doctorid}")
    public List<Appointement> getByDoctorid(@PathVariable String doctorid){
        return this.appsrvice.getByDoctorid(doctorid);
    }

    @PostMapping("/appointement/")
    @Transactional
    public ResponseEntity<Object> createappointement(@RequestBody AppointementDto appdto) {
        Appointement appsave =this.appsrvice.createAppointement(appdto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(appsave.getId()).toUri();
        return ResponseEntity.created(location).build();


    }
    @DeleteMapping("/appointement/{id}")
    @Transactional
    public void deleteappointement( @PathVariable int id) {
        this.appsrvice.deleteAppointement(id);


    }
    @PutMapping("/appointement/{id}")
    @Transactional
    public Appointement updateappointement(@RequestBody AppointementDto appdto , @PathVariable int id) {
        return this.appsrvice.ubdateAppointement(appdto,id);


    }
    @PutMapping("/appointement/status/{id}")
    @Transactional
    public Appointement updateappointementStatus(@RequestBody AppointementDto appdto , @PathVariable int id) {
        return this.appsrvice.ubdateAppointementStatus(appdto,id);
    }
}
