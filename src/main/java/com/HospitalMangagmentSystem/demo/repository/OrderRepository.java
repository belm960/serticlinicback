package com.HospitalMangagmentSystem.demo.repository;

import com.HospitalMangagmentSystem.demo.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Integer> {

}
