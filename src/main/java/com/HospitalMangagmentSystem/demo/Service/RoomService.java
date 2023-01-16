package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.RoomDto;
import com.HospitalMangagmentSystem.demo.domain.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {

    List<Room> getAllRoom();

    Room getOneRoom(int id);

    Room createRoom(RoomDto roomDto);

    void deleteRoom(int id);

    Room updateRoom(RoomDto roomDto , int id);

}
