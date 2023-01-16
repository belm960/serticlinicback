package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.domain.User;
import com.HospitalMangagmentSystem.demo.Security.jwt.message.request.SignUpForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getalluser();

    List<User> getbyroleNp();

    User getoneuser(int id);

    String getoneuserdType(String username);

    Boolean getoneuserStatus(String username);

    int getoneuserid(String username);

    List<User> getdType(String dType);

    List<User> getbyrole(String department);

    List<User> getbyroleDoctor();

    User updateauser(int id, SignUpForm user);

    User updateUserStatus(int id, SignUpForm userdto);

    void delteuser(int id);

}
