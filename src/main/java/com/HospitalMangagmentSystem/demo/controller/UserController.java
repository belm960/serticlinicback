package com.HospitalMangagmentSystem.demo.controller;

import com.HospitalMangagmentSystem.demo.Service.UserService;
import com.HospitalMangagmentSystem.demo.domain.User;
import com.HospitalMangagmentSystem.demo.Security.jwt.message.request.SignUpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    UserService userservice;

    @GetMapping("/User")
    public List<User> getuser() {

        return this.userservice.getalluser();
    }

    @GetMapping("/User/nop")
    public List<User> getUserNop() {
        return this.userservice.getbyroleNp();
    }

    @GetMapping("/user/{dType}")
    public List<User> getbydType(@PathVariable String dType) {

        return this.userservice.getdType(dType);
    }

    @GetMapping("/User/role/{department}")
    public List<User> getuserrole(@PathVariable String department) {

        return this.userservice.getbyrole(department);
    }

    @GetMapping("/User/roleDoctor")
    public List<User> getDoctor() {
        return this.userservice.getbyroleDoctor();
    }

    @GetMapping("/User/{id}")
    @Transactional
    public User getoneuser(@PathVariable int id) {

        return this.userservice.getoneuser(id);

    }

    @DeleteMapping("/User/{id}")
    @Transactional
    public void delteuser(@PathVariable int id) {
        this.userservice.delteuser(id);
    }

    @PutMapping("/Update/{id}")
    @Transactional
    public void updateuser(@PathVariable int id, @RequestBody SignUpForm singupform) {
        this.userservice.updateauser(id, singupform);
    }

    @PutMapping("/updateStatus/{id}")
    @Transactional
    public User updateUserStatus(@PathVariable int id, @RequestBody SignUpForm singupform) {

        return this.userservice.updateUserStatus(id, singupform);

    }

}
