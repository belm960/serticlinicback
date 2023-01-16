package com.HospitalMangagmentSystem.demo.controller;

import com.HospitalMangagmentSystem.demo.Dto.PaymentDto;

import com.HospitalMangagmentSystem.demo.Service.PaymentService;

import com.HospitalMangagmentSystem.demo.domain.PatientsPayment;
import com.HospitalMangagmentSystem.demo.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PaymentController {
    @Autowired
    PaymentService payservice;

    @GetMapping("/Payment")
    public List<Payment> getpayment(){
        return this.payservice.getpayments();
    }
    @GetMapping("/AllPayment")
    public List<PatientsPayment> getAllpayment(){
        return this.payservice.getAllpayment();
    }
    @GetMapping("/AllPaymentOfVisit/{vid}")
    public List<PatientsPayment> getAllpayment(@PathVariable String vid){
        return this.payservice.getAllpaymentByVisit(vid);
    }
    @GetMapping("/NotPaidPayment")
    public List<PatientsPayment> getpaymentNPayed(){
        return this.payservice.getpaymentNPayed();
    }
    @GetMapping("/PaidPayment")
    public List<PatientsPayment> getpaymentPayed(){
        return this.payservice.getpaymentPayed();
    }
    @GetMapping("/VoidPayment")
    public List<PatientsPayment> getpaymentVoid(){
        return this.payservice.getpaymentVoid();
    }
    @GetMapping("/VoucherPayment")
    public List<PatientsPayment> getpaymentVoucher(){
        return this.payservice.getpaymentVoucher();
    }
    @PostMapping("/Payment/")
    @Transactional
    public ResponseEntity<Object> createpayment(@RequestBody PaymentDto paydto) {
        Payment paysave =this.payservice.createpayment(paydto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(paysave.getPayment_id()).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/payment/{id}")
    @Transactional
    public Payment getonepayment( @PathVariable int id) {
        return this.payservice.getpayment(id);
    }
    @DeleteMapping("/payment/{id}")
    @Transactional
    public void deletepatient(@RequestBody PaymentDto paydto , @PathVariable int id) {
        this.payservice.deletepayment(id);
    }
    @PutMapping("/payment/{id}")
    @Transactional
    public Payment updatePayment(@RequestBody PaymentDto paydto , @PathVariable int id) {
        return this.payservice.ubdatepatienttreat(paydto, id);


    }
    @PutMapping("/paymentStatus/{id}")
    @Transactional
    public Payment updateStatus(@RequestBody PaymentDto paydto , @PathVariable int id) {
        return this.payservice.ubdateStatus(paydto, id);
    }
    @PutMapping("/paymentvid/{id}")
    @Transactional
    public Payment updateRegistration(@RequestBody PaymentDto paydto , @PathVariable int id) {
        return this.payservice.ubdateRegistration(paydto, id);
    }

}




