package com.HospitalMangagmentSystem.demo.Security.Service;

import com.HospitalMangagmentSystem.demo.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
public class UserPrinciple implements UserDetails {

    private static final long serialVersionUID = 1L;
    private int id;
    private String first;
    private String last;
    private String mobile;
    private String designation;
    private String address;
    private String education;
    private String gender;
    private String department;
    private String age;
    private String enrolldate;
    private String gfname;

    public String getdType() {
        return dType;
    }
    public void setdType(String dType) {
        this.dType = dType;
    }
    private String dType;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    public UserPrinciple(int id,String first,String last,String mobile,String designation,
                         String address,String dType,String gender,
                         String department,
                         String username, String email, String password, String age, String enrolldate , String gfname,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.mobile = mobile;
        this.designation = designation;
        this.address = address;
        this.dType = dType;
        this.department = department;
        this.gender = gender;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enrolldate = enrolldate;
        this.gfname = gfname;
        this.age = age;
        this.authorities = authorities;
    }
    public static UserPrinciple	build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());
        return new UserPrinciple(
                user.getId(),
                user.getFirst(),
                user.getLast(),
                user.getMobile(),
                user.getDesignation(),
                user.getAddress(),
                user.getdType(),
                user.getGender(),
                user.getDepartment(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getEnrolldate(),
                user.getAge(),
                user.getGfname(),

                authorities
        );
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    @Override

    public String getUsername() {
        return username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrinciple	user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDesignation() {
        return designation;
    }

    public String getAddress() {
        return address;
    }

    public String getEducation() {
        return education;
    }

    public String getAge() {
        return age;
    }

    public String getEnrolldate() {
        return enrolldate;
    }

    public String getGfname() {
        return gfname;
    }

}

