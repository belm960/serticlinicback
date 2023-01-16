package com.HospitalMangagmentSystem.demo.repository;

import com.HospitalMangagmentSystem.demo.domain.LabPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabPriceRespository extends JpaRepository<LabPrice,Integer> {

}
