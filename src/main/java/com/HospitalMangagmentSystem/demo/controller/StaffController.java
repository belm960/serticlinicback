package com.HospitalMangagmentSystem.demo.controller;


import com.HospitalMangagmentSystem.demo.Dto.StaffDto;
import com.HospitalMangagmentSystem.demo.Service.StaffService;
import com.HospitalMangagmentSystem.demo.domain.Staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 200000)
@RestController
public class StaffController {

    @Autowired
    StaffService staffService;

    @GetMapping("/Staff")
    public List<Staff> getStaff()   {
        return this.staffService.getAllStaff();
    }

    @GetMapping("/Staff/{id}")
    public Staff getOneStaff(@PathVariable int id ){
        return this.staffService.getOneStaff(id);
    }

    @PostMapping("/Staff/")
    @Transactional
    public ResponseEntity<Object> createStaff(@RequestBody StaffDto sdt){

        Staff staff = this.staffService.createStaff(sdt);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(staff.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/Staff/{id}")
    public Staff updateStaff(@PathVariable int id, @RequestBody StaffDto sdt){

        return this.staffService.updateStaff(sdt,id);
    }

    @DeleteMapping("/Staff/{id}")
    public void deleteStaff(@PathVariable int id){

        this.staffService.deleteStaff(id);
    }

}