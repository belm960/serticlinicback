package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.PaymentDto;
import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import com.HospitalMangagmentSystem.demo.domain.*;
import com.HospitalMangagmentSystem.demo.repository.paymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class PaymentserviceImplementation implements PaymentService{
    @Autowired
    paymentRepository payrep;
    @Override
    public List<Payment> getpayments() {
        return payrep.findAll();
    }
    @Override
    public List<PatientsPayment> getAllpayment() {
        return payrep.findAllPayment();
    }
    @Override
    public List<PatientsPayment> getAllpaymentByVisit(String vid) {
        return payrep.findAllPaymentByVisit(vid);
    }
    @Override
    public List<PatientsPayment> getpaymentNPayed() {
        return payrep.findPaymentNPayed();
    }
    @Override
    public List<PatientsPayment> getpaymentPayed() {
        return payrep.findPaymentPayed();
    }
    @Override
    public List<PatientsPayment> getpaymentVoucher() {
        return payrep.findPaymentVoucher();
    }
    @Override
    public List<PatientsPayment> getpaymentVoid() {
        return payrep.findPaymentVoid();
    }
    @Override
    public Payment getpayment(int id) {
        Payment pp = payrep.findById(id).orElseThrow(()->
                new DataNotFoundException("payment with id " + id + " not found") );
        return null;
    }
    @Override
    public Payment createpayment(PaymentDto paydto) {
        Payment pp = new Payment();
        pp.setCost(paydto.getCost());
        pp.setTotal(paydto.getTotal());
        pp.setTitle(paydto.getTitle());
        pp.setDate(paydto.getDate());
        pp.setPid(paydto.getPid());
        pp.setVid(paydto.getVid());
        pp.setStatus("NOT_PAYED");
        return payrep.save(pp);
    }
    @Override
    public void deletepayment(int id) {
        Payment pp = payrep.findById(id).orElseThrow(()->
                new DataNotFoundException("payment with id " + id + " not found") );
         payrep.deleteById(id);
    }
    @Override
    public Payment ubdatepatienttreat(PaymentDto paydto, int id) {
        Payment pp = payrep.findById(id).orElseThrow(()->
                new DataNotFoundException("payment with id " + id + " not found") );

        pp.setCost(paydto.getCost());
        pp.setTotal(paydto.getTotal());

        return payrep.save(pp);
    }
    @Override
    public Payment ubdateStatus(PaymentDto paydto, int id) {
        Payment pp = payrep.findById(id).orElseThrow(()->
                new DataNotFoundException("payment with id " + id + " not found") );
        pp.setStatus(paydto.getStatus());
        return payrep.save(pp);
    }
    @Override
    public Payment ubdateRegistration(PaymentDto paydto, int id) {
        Payment pp = payrep.findPaymentBYNameANdPid(id);
        pp.setVid(paydto.getVid());
        return payrep.save(pp);
    }

}
