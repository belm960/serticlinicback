package com.HospitalMangagmentSystem.demo.repository;



import com.HospitalMangagmentSystem.demo.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, String> {

    @Query("SELECT v FROM Visit v WHERE v.pid = ?1")
    List<Visit> findByName(String pid);

}
