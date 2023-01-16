package com.HospitalMangagmentSystem.demo.controller;

import com.HospitalMangagmentSystem.demo.Dto.LabPriceDto;
import com.HospitalMangagmentSystem.demo.Service.LabPriceService;
import com.HospitalMangagmentSystem.demo.domain.LabPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 200000)
@RestController
public class LabPriceController {
    @Autowired
    LabPriceService rdservice;

    @GetMapping("/LabPrice")
    public List<LabPrice> getAll(){
        return this.rdservice.getAll();
    }

    @GetMapping("/LabPrice/{id}")
    public LabPrice getOne(@PathVariable int id){
        return this.rdservice.getOne(id);
    }
    @PostMapping("/LabPrice/")
    public ResponseEntity<?> createTest(@RequestBody LabPriceDto rdt){
        LabPrice rd = this.rdservice.createTest(rdt);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(rd.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PostMapping("/LabPrice1/")
    public List<LabPrice> createTest1(@RequestBody LabPriceDto rdt){
        return  this.rdservice.createTest1(rdt);
    }

    @PutMapping("/LabPrice/{id}")
    public LabPrice updateTest(@PathVariable int id, @RequestBody LabPriceDto rdt){
        return this.rdservice.updateTest(rdt,id);
    }

    @DeleteMapping("/LabPrice/{id}")
    public void deleteTest(@PathVariable int id){
        this.rdservice.deleteTest(id);
    }
}
