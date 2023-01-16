package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.RoomDto;
import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import com.HospitalMangagmentSystem.demo.domain.Room;
import com.HospitalMangagmentSystem.demo.repository.RoomRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@JsonDeserialize
public class RoomServiceImplementation implements RoomService{
    @Autowired
    RoomRepository roomRepo;

    @Override
    public List<Room> getAllRoom(){
        return this.roomRepo.findAll();
    }

    @Override
    public Room getOneRoom(int id){
        Room room = roomRepo.findById(id).orElseThrow( () ->
        new DataNotFoundException("Room with " + id + "Not Found"));
        return room;
    }

    @Override
    public Room createRoom(RoomDto roomDto){
        Room room = new Room();
        room.setpName(roomDto.getpName());
        room.setpSex(roomDto.getpSex());
        room.setRoomNo(roomDto.getRoomNo());
        room.setRoomType(roomDto.getRoomType());
        room.setAdmitDate(roomDto.getAdmitDate());
        room.setDischargeDate(roomDto.getDischargeDate());
        room.setPid(roomDto.getPid());

        return this.roomRepo.save(room);
    }


    @Override
    public Room updateRoom(RoomDto roomDto,int id){
        Room room = this.roomRepo.findById(id).orElseThrow(()->
                new DataNotFoundException("Room With " +id+"not Found"));
        room.setpName(roomDto.getpName());
        room.setpSex(roomDto.getpSex());
        room.setRoomNo(roomDto.getRoomNo());
        room.setRoomType(roomDto.getRoomType());
        room.setAdmitDate(roomDto.getAdmitDate());
        room.setDischargeDate(roomDto.getDischargeDate());
        room.setPid(roomDto.getPid());

        return this.roomRepo.save(room);

    }
    @Override
    public void deleteRoom(int id){
        this.roomRepo.deleteById(id);
    }
}
