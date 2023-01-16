package com.HospitalMangagmentSystem.demo.controller;


import com.HospitalMangagmentSystem.demo.Dto.RadPriceDto;
import com.HospitalMangagmentSystem.demo.Service.RadPriceService;
import com.HospitalMangagmentSystem.demo.domain.RadPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 200000)
@RestController
public class RadPriceController {
    @Autowired
    RadPriceService rdservice;

    @GetMapping("/RadPrice")
    public List<RadPrice> getAll(){
        return this.rdservice.getAll();
    }

    @GetMapping("/RadPrice/{id}")
    public RadPrice getOne(@PathVariable int id){
        return this.rdservice.getOne(id);
    }
    @PostMapping("/RadPrice/")
    public ResponseEntity<?> createTest(@RequestBody RadPriceDto rdt){
        RadPrice rd = this.rdservice.createTest(rdt);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(rd.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PostMapping("/RadPrice1/")
    public List<RadPrice> createTest1(@RequestBody RadPriceDto rdt){
        return  this.rdservice.createTest1(rdt);
    }

    @PutMapping("/RadPrice/{id}")
    public RadPrice updateTest(@PathVariable int id, @RequestBody RadPriceDto rdt){
        return this.rdservice.updateTest(rdt,id);
    }

    @DeleteMapping("/RadPrice/{id}")
    public void deleteTest(@PathVariable int id){
        this.rdservice.deleteTest(id);
    }
}
