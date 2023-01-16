package com.HospitalMangagmentSystem.demo.repository;

import com.HospitalMangagmentSystem.demo.domain.Appointement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface appointementRepository extends JpaRepository<Appointement, Integer> {

    @Query("SELECT a FROM Appointement a WHERE a.pid = ?1 AND a.status=?2")
    List<Appointement> findByIdAndStatus(String pid,String status);
    @Query("SELECT a FROM Appointement a WHERE a.pid = ?1")
    List<Appointement> findByPatientId(String pid);
    List<Appointement> findByDoctorid(String doctorid);


}
