package com.HospitalMangagmentSystem.demo.repository;

import com.HospitalMangagmentSystem.demo.domain.Radiology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RadiologyRepository extends JpaRepository<Radiology,Integer> {

    @Query("SELECT r FROM Radiology r WHERE r.vid=?1")
    List<Radiology> findByVisit(String vid);
}
