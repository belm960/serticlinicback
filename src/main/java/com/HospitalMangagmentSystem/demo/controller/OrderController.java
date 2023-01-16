package com.HospitalMangagmentSystem.demo.controller;

import com.HospitalMangagmentSystem.demo.Dto.OrderDto;
import com.HospitalMangagmentSystem.demo.Service.OrderService;
import com.HospitalMangagmentSystem.demo.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

public class OrderController {
        @Autowired
        OrderService orderservice;

        @GetMapping("/Orders")
        public List<Orders> getorder(){

            return this.orderservice.getallorder();
        }

        @PostMapping("/Orders/")
        @Transactional
        public ResponseEntity<Object> createorder(@RequestBody OrderDto ord) {
            Orders ordersave =this.orderservice.createorder(ord);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(ordersave.getOrder_ID()).toUri();
            return ResponseEntity.created(location).build();


        }

        @GetMapping("/Orders/{id}")
        @Transactional
        public Orders getoneorder( @PathVariable int id) {

            return this.orderservice.getoneorder(id);

        }

        @DeleteMapping("/Orders/{id}")
        @Transactional
        public void deleteorder( @PathVariable int id) {
            this.orderservice.deleteorder(id);


        }

        @PutMapping("/Orders/{id}")
        @Transactional
        public Orders updateorder(@RequestBody OrderDto order , @PathVariable int id) {
            return this.orderservice.ubdateorder(order, id);
        }

}


