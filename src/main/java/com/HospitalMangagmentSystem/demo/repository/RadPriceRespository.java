package com.HospitalMangagmentSystem.demo.repository;

import com.HospitalMangagmentSystem.demo.domain.RadPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadPriceRespository extends JpaRepository<RadPrice,Integer> {

}
