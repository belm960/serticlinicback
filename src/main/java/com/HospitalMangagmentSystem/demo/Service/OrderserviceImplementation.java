package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.OrderDto;

import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;

import com.HospitalMangagmentSystem.demo.domain.Orders;

import com.HospitalMangagmentSystem.demo.repository.OrderRepository;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
@Component
@JsonDeserialize
public class OrderserviceImplementation implements OrderService {
        @Autowired
        OrderRepository orderrep;
        @Override
        public List<Orders> getallorder() {
            // TODO Auto-generated method stub
            return orderrep.findAll();
        }

        @Override
        public Orders getoneorder(int id) {
            // TODO Auto-generated method stub
            Orders oo=orderrep.findById(id).orElseThrow(()->
                    new DataNotFoundException("Order with id " + id + " not found") );

            return oo;
        }
        @Override
        @Transactional
        public Orders createorder(OrderDto orderDto) {
            Orders or = new Orders();

            or.setDrug(orderDto.getDrug());

            or.setDiscontinued(orderDto.getDiscontinued());
            or.setRefill(orderDto.getRefill());
            or.setRecordType(orderDto.getRecordType());
            or.setDosage(orderDto.getDosage());
            or.setRoute(orderDto.getRoute());
            or.setFrequency(orderDto.getFrequency());
            or.setDuration(orderDto.getDuration());
            or.setDispense(orderDto.getDispense());
            or.setReasonForPrescription(orderDto.getReasonForPrescription());
            or.setOrderNote(orderDto.getOrderNote());

            or.setOrderDate(orderDto.getOrderDate());
            or.setPatients(or.getPatients());


            return or;
        }


        @Override
        public void deleteorder(int id) {
            // TODO Auto-generated method stub
            Orders order = orderrep.findById(id).orElseThrow(()->
                    new DataNotFoundException("patient with id " + id + " not found") );
            orderrep.delete(order);
        }

        @Override
        public Orders ubdateorder(OrderDto orderDto, int id) {
            // TODO Auto-generated method stub
            Orders order =orderrep.findById(id).orElseThrow(()->
                    new DataNotFoundException("Order with id " + id + " not found") );
            Orders or = new Orders();

            or.setDrug(orderDto.getDrug());

            or.setDiscontinued(orderDto.getDiscontinued());
            or.setRefill(orderDto.getRefill());
            or.setRecordType(orderDto.getRecordType());
            or.setDosage(orderDto.getDosage());
            or.setRoute(orderDto.getRoute());
            or.setFrequency(orderDto.getFrequency());
            or.setDuration(orderDto.getDuration());
            or.setDispense(orderDto.getDispense());
            or.setReasonForPrescription(orderDto.getReasonForPrescription());
            or.setOrderNote(orderDto.getOrderNote());

            or.setOrderDate(orderDto.getOrderDate());
            or.setPatients(or.getPatients());


            return orderrep.save(order);

        }

    }
