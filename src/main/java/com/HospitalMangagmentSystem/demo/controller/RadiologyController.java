package com.HospitalMangagmentSystem.demo.controller;

import com.HospitalMangagmentSystem.demo.Dto.RadiologyDto;
import com.HospitalMangagmentSystem.demo.Service.RadiologyService;
import com.HospitalMangagmentSystem.demo.domain.Radiology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 200000)
@RestController
public class RadiologyController {
        @Autowired
        RadiologyService radservice;
        @GetMapping("/Radiology")
        public List<Radiology> getRadiology ()   {
            return this.radservice.getallRadiology();
        }
        @GetMapping("/Radiology/{id}")
        public Radiology getUserRadiologyByid(@PathVariable int id, @RequestBody RadiologyDto rad ){
            return  radservice.getoneRadiology(id);
        }
        @GetMapping("/Radiology/vid/{vid}")
        public List<Radiology> getUserRadiologyByVid(@PathVariable String vid){
            return  radservice.getoneRadiologyByVisit(vid);
        }
        @PostMapping("/Radiology/")
        @Transactional
        public ResponseEntity<Object> createRadiology(@RequestBody RadiologyDto rad ){

            Radiology radsave = this.radservice.createRadiology(rad);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(radsave.getRadid()).toUri();
            return ResponseEntity.created(location).build();
        }
        @PutMapping("/Radiology/{id}")
        public Radiology updateRadiology(@PathVariable int id, @RequestBody RadiologyDto rad){
            return this.radservice.ubdateRadiology(rad, id);
        }
        @DeleteMapping("/Radiology/{id}")
        public void deleteRadiology(@PathVariable int id){
            this.radservice.deleteRadiology(id);
        }
    }


