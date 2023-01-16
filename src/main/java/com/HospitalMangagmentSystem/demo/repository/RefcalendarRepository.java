package com.HospitalMangagmentSystem.demo.repository;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HospitalMangagmentSystem.demo.domain.Refcalendar;
@Repository
public interface RefcalendarRepository extends JpaRepository<Refcalendar, Date> {

	

	

}
