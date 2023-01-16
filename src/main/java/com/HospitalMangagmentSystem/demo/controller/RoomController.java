package com.HospitalMangagmentSystem.demo.controller;

import com.HospitalMangagmentSystem.demo.Dto.RoomDto;
import com.HospitalMangagmentSystem.demo.Service.RoomService;
import com.HospitalMangagmentSystem.demo.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 200000)
@RestController
public class RoomController {

    @Autowired
    RoomService roomService;
    @GetMapping("/Room")
    public List<Room> getAllRoom(){
        return this.roomService.getAllRoom();
    }
    @GetMapping("/Room/{id}")
    public Room getOnePatient(@PathVariable  int id){
        return this.roomService.getOneRoom(id);
    }
    @PostMapping("/Room/")
    public ResponseEntity<Object> createRoom(@RequestBody RoomDto roomDto){
        Room room = this.roomService.createRoom(roomDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(room.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/Room/{id}")
    public Room updateRoom(@PathVariable int id,@RequestBody RoomDto roomDto){
        return this.roomService.updateRoom(roomDto,id);
    }
    @DeleteMapping("/Room/{id}")
    public void deleteRoom(@PathVariable int id){
        this.roomService.deleteRoom(id);
    }
}
