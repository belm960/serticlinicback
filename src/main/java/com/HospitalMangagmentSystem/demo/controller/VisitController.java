package com.HospitalMangagmentSystem.demo.controller;

import com.HospitalMangagmentSystem.demo.Dto.VisitDto;
import com.HospitalMangagmentSystem.demo.Service.VisitService;
import com.HospitalMangagmentSystem.demo.domain.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class VisitController {
    @Autowired
    VisitService vservice;


    @GetMapping("/Visits/{pid}")
    @Transactional
    public List<Visit> getbypid(@PathVariable String pid){
     return this.vservice.getbypid(pid);
    }

    @GetMapping("/Visit/{id}")
    @Transactional
    public Visit getonevisit(@PathVariable String id) {
        return this.vservice.getonevisit(id);
    }

    @PostMapping("/Visit/")
    @Transactional
    public ResponseEntity<Object> createvisit(@RequestBody VisitDto vdto) {
        Visit vsave = vservice.createvisit(vdto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(vsave.getId()).toUri();
        return ResponseEntity.created(location).build();


    }

    @DeleteMapping("/Visit/{id}")
    @Transactional
    public void deltevisit( @PathVariable String id) {
        this.vservice.deletevisit(id);
}

    @PutMapping("/Visit/{id}")
    @Transactional
    public Visit updatevisit(@RequestBody VisitDto vdto , @PathVariable String id) {
        return this.vservice.updatevisit(vdto,id);
    }


}
