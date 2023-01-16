package com.HospitalMangagmentSystem.demo.repository;

import com.HospitalMangagmentSystem.demo.domain.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaboratoryRepository extends JpaRepository <Laboratory,Integer>{


    @Query("SELECT l FROM Laboratory l WHERE l.vid=?1")
    List<Laboratory> findByVisit(String vid);
}
