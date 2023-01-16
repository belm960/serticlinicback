package com.HospitalMangagmentSystem.demo.controller;

import com.HospitalMangagmentSystem.demo.domain.Role;
import com.HospitalMangagmentSystem.demo.domain.Rolename;
import com.HospitalMangagmentSystem.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class RoleController {
    @Autowired
    RoleRepository roalrepository;
    @PostMapping("/role")
    @Transactional
    public void createrole() {
             Role role = new Role();
             role.setName(Rolename.ROLE_USER);
             roalrepository.save(role);
             Role role2 = new Role();
            role2.setName(Rolename.ROLE_DOCTOR);
             roalrepository.save(role2);




    }
}
