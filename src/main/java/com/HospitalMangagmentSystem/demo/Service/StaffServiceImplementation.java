package com.HospitalMangagmentSystem.demo.Service;


import com.HospitalMangagmentSystem.demo.Dto.StaffDto;
import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import com.HospitalMangagmentSystem.demo.domain.Staff;
import com.HospitalMangagmentSystem.demo.repository.StaffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StaffServiceImplementation implements StaffService{

    @Autowired
    StaffRepository staffrepo;


    @Override
    public List<Staff> getAllStaff() {
        // TODO Auto-generated method stub
        return staffrepo.findAll();
    }

    @Override
    public Staff getOneStaff(int id) {
        // TODO Auto-generated method stub
        Staff staff=staffrepo.findById(id).orElseThrow(()->
                new DataNotFoundException("Staff with id " + id + " not found") );
        return staff;
    }

    @Override
    public Staff  createStaff(StaffDto sdt) {
        // TODO Auto-generated method stub
        Staff staff = new Staff();

        staff.setAddress(sdt.getAddress());
        staff.setDepartment(sdt.getDepartment());
        staff.setDesignation(sdt.getDesignation());
        staff.setDob(sdt.getDob());
        staff.setFirst(sdt.getFirst());
        staff.setLast(sdt.getLast());
        staff.setEmail(sdt.getEmail());
        staff.setEducation(sdt.getEducation());
        staff.setMobile(sdt.getMobile());
        staff.setGender(sdt.getGender());
        return staffrepo.save(staff);
    }

    @Override
    public void deleteStaff(int id) {
        // TODO Auto-generated method stub
        staffrepo.deleteById(id);
    }

    @Override
    public Staff updateStaff(StaffDto sdt, int id) {
        // TODO Auto-generated method stub
        Staff staff = staffrepo.findById(id).orElseThrow(()->
                new DataNotFoundException("Staff with id " + id + " not found") );


        staff.setAddress(sdt.getAddress());
        staff.setDepartment(sdt.getDepartment());
        staff.setDesignation(sdt.getDesignation());
        staff.setDob(sdt.getDob());
        staff.setFirst(sdt.getFirst());
        staff.setLast(sdt.getLast());
        staff.setEmail(sdt.getEmail());
        staff.setEducation(sdt.getEducation());
        staff.setMobile(sdt.getMobile());
        staff.setGender(sdt.getGender());

        return staffrepo.save(staff);
    }
}
