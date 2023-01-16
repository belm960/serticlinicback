package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.PaymentDto;

import com.HospitalMangagmentSystem.demo.domain.PatientsPayment;
import com.HospitalMangagmentSystem.demo.domain.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    List<Payment> getpayments();
    List<PatientsPayment> getAllpayment();
    List<PatientsPayment> getAllpaymentByVisit(String vid);
    List<PatientsPayment> getpaymentPayed();
    List<PatientsPayment> getpaymentNPayed();
    List<PatientsPayment> getpaymentVoid();
    List<PatientsPayment> getpaymentVoucher();
    Payment getpayment(int id);
    Payment createpayment(PaymentDto paydto);
    void deletepayment(int id);
    Payment ubdatepatienttreat(PaymentDto paydto , int id);
    Payment ubdateStatus(PaymentDto paydto, int id);
    Payment ubdateRegistration(PaymentDto paydto, int id);
}


