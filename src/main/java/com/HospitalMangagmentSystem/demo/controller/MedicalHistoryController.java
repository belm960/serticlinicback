package com.HospitalMangagmentSystem.demo.controller;

import com.HospitalMangagmentSystem.demo.Dto.MedicalHistoryDto;

import com.HospitalMangagmentSystem.demo.Service.MedicalHistoryService;
import com.HospitalMangagmentSystem.demo.domain.MedicalHistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
public class MedicalHistoryController {
    @Autowired
    MedicalHistoryService medicalHistoryService;

    @GetMapping("/MedicalHistory/")
    public List<MedicalHistory> gettreatment() {
        return this.medicalHistoryService.getallmedicalhistory();
    }

    @GetMapping("/MedicalHistory/{id}")
    @Transactional
    public MedicalHistory meddicalhistorybyid(@PathVariable int id) {

        return this.medicalHistoryService.getonemedicalhistory(id);
    }


    @PostMapping("/MedicalHistory/{id}")
    @Transactional
    public ResponseEntity<Object> createmedicalhistory(@RequestBody MedicalHistoryDto mhdto,@PathVariable int id) {


        MedicalHistory mhis = this.medicalHistoryService.createmedicalhistory(mhdto,id);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mhis.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/MedicalHistory/{id}")
    @Transactional
    public void delete( @PathVariable int id) {
        this.medicalHistoryService.deletemedicalhistory(id);
    }

    @PutMapping("/Medicalhistory/{id}")
    @Transactional
    public MedicalHistory update(@RequestBody MedicalHistoryDto mhdto , @PathVariable int id) {

        return this.medicalHistoryService.updatemedicalhistory(mhdto, id);
    }
}

