package com.HospitalMangagmentSystem.demo.repository;

import com.HospitalMangagmentSystem.demo.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {


}
