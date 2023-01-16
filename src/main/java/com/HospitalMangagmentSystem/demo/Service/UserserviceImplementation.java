package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import com.HospitalMangagmentSystem.demo.Security.jwt.message.request.SignUpForm;
import com.HospitalMangagmentSystem.demo.domain.Rolename;
import com.HospitalMangagmentSystem.demo.domain.User;
import com.HospitalMangagmentSystem.demo.repository.RoleRepository;
import com.HospitalMangagmentSystem.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserserviceImplementation implements UserService {
    @Autowired
    UserRepository userep;

    @Autowired
    RoleRepository rolrep;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public List<User> getalluser() {
        return userep.findAll();
    }

    @Override
    public List<User> getbyroleNp() {
        List<User> ar = userep.findAll();
        List<User> pat = userep.findUserByRoles(rolrep.findByName(Rolename.ROLE_PATIENT).orElse(null));
        pat.forEach(element -> {
            ar.remove(element);
        });
        return ar;

    }

    @Override
    public User getoneuser(int id) {
        User use = userep.findById(id)
                .orElseThrow(() -> new DataNotFoundException("patient with id " + id + " not found"));

        return use;
    }

    @Override
    public String getoneuserdType(String username) {
        User use = userep.findByUsername(username)
                .orElseThrow(() -> new DataNotFoundException(" with id " + username + " not found"));

        return use.dType;
    }

    @Override
    public Boolean getoneuserStatus(String username) {
        User use = userep.findByUsername(username)
                .orElseThrow(() -> new DataNotFoundException(" with id " + username + " not found"));
        return use.getStatus();
    }

    @Override
    public int getoneuserid(String username) {
        User use = userep.findByUsername(username)
                .orElseThrow(() -> new DataNotFoundException(" with username " + username + " not found"));

        return use.getId();
    }

    @Override
    public List<User> getdType(String dType) {
        return userep.findByName(dType);
    }

    @Override
    public List<User> getbyrole(String department) {
        return userep.findUserByRolesAndDepartment(rolrep.findByName(Rolename.ROLE_DOCTOR).orElse(null), department);
    }

    @Override
    public List<User> getbyroleDoctor() {
        return userep.findUserByRoles(rolrep.findByName(Rolename.ROLE_DOCTOR).orElse(null));
    }

    @Override
    public User updateauser(int id, SignUpForm userdto) {
        User user = userep.findById(id)
                .orElseThrow(() -> new DataNotFoundException("patient with id " + id + " not found"));
        user.setFirst(userdto.getFirst());
        user.setLast(userdto.getLast());
        user.setGender(userdto.getGender());
        user.setAge(userdto.getAge());
        user.setGfname(userdto.getGfname());
        user.setEmail(userdto.getEmail());
        user.setMobile(userdto.getMobile());
        user.setDepartment(userdto.getDepartment());
        user.setDesignation(userdto.getDesignation());
        user.setdType(userdto.getdType());
        user.setAddress(userdto.getAddress());
        user.setUsername(userdto.getUsername());
        user.setPassword(encoder.encode(userdto.getPassword()));

        userep.save(user);
        return user;
    }

    @Override
    public User updateUserStatus(int id, SignUpForm userdto) {
        User user = userep.findById(id)
                .orElseThrow(() -> new DataNotFoundException("patient with id " + id + " not found"));
        user.setStatus(userdto.getStatus());
        userep.save(user);
        return user;
    }

    @Override
    public void delteuser(int id) {
        // TODO Auto-generated method stub
        User use = userep.findById(id)
                .orElseThrow(() -> new DataNotFoundException("patient with id " + id + " not found"));
        userep.delete(use);
    }

}
