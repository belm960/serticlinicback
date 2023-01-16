package com.HospitalMangagmentSystem.demo.repository;


import com.HospitalMangagmentSystem.demo.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository  extends JpaRepository<Staff,Integer> {


}
