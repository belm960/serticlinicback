package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.OrderDto;
import com.HospitalMangagmentSystem.demo.domain.Orders;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@JsonDeserialize
public interface OrderService {

        List<Orders> getallorder();

        Orders getoneorder(int id);

        Orders createorder(OrderDto order);

        void deleteorder(int id);

       Orders ubdateorder(OrderDto order , int id);

}
