package com.HospitalMangagmentSystem.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User {
    @Id
    private int id;
    @NotBlank
    @Size(min = 3, max = 50)
    private String username;
    private String address;
    //private String conformPassword;

    private String department;
    private String designation;
    private String enrolldate;
    //date of joining
    @NotBlank
    @Size(min = 6, max = 100)
    private String password;
    private String first;
    private String last;
    private String gfname;
    private String mobile;
    private String gender;
    private String age;
    private Boolean status;



    //bi-directional many-to-one association to DoctorsVisit
    @OneToMany(fetch = FetchType.LAZY,mappedBy="doctor",  cascade = CascadeType.ALL)

    @JsonIgnore
    private Set<Appointement> appointements;
    //bi-directional one-to-one association to Encounter
    @OneToMany(fetch = FetchType.LAZY,mappedBy="doctor",  cascade = CascadeType.ALL)
    //@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<DoctorsVisit> encounter;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    public String dType;

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public String getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(String enrolldate) {
        this.enrolldate = enrolldate;
    }

    public String getGfname() {
        return gfname;
    }

    public void setGfname(String gfname) {
        this.gfname = gfname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public User() {
    }

    public User( int id,String username, String email,
                 String first,String last,String enrolldate,String mobile,String designation,String address,
                 String age, String gfname,String gender,String department,String dType,String password,boolean status
    ) {
        this.id=id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.first = first;
        this.last = last;
        this.enrolldate = enrolldate;
        this.mobile = mobile;
        this.designation= designation;
        this.address = address;
        this.dType = dType;
        this.gender = gender;
        this.department=department;
        this.age = age;
        this.gfname = gfname;
        this.dType=dType;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public Set<Appointement> getAppointements() {
        return appointements;
    }

    public void setAppointements(Set<Appointement> appointements) {
        this.appointements = appointements;
    }
    public Appointement addAppointment(Appointement appointement) {
        if (appointements == null) {
            appointements = new HashSet<Appointement>();
        }
        getAppointements().add(appointement);
        appointement.setDoctor(this);

        return appointement;
    }



    public DoctorsVisit addDoctor(DoctorsVisit appointement) {
        if (encounter == null) {
            encounter = new HashSet<DoctorsVisit>();
        }
        getEncounter().add(appointement);
        appointement.setDoctor(this);


        return appointement;
    }

    public Set<DoctorsVisit> getEncounter() {
        return encounter;
    }

    public void setEncounter(Set<DoctorsVisit> encounter) {
        this.encounter = encounter;
    }
}
