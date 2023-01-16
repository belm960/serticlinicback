package com.HospitalMangagmentSystem.demo.repository;

import com.HospitalMangagmentSystem.demo.domain.PatientsPayment;
import com.HospitalMangagmentSystem.demo.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface paymentRepository extends JpaRepository<Payment, Integer> {

    @Query("SELECT new com.HospitalMangagmentSystem.demo.domain.PatientsPayment(p.payment_id,a.first,a.last,p.cost,p.date,p.title,p.pid,p.vid,p.status,a.address) FROM Patients a , Payment p WHERE a.Patient_ID = p.pid ")
    List<PatientsPayment> findAllPayment();

    @Query("SELECT new com.HospitalMangagmentSystem.demo.domain.PatientsPayment(p.payment_id,a.first,a.last,p.cost,p.date,p.title,p.pid,p.vid,p.status,a.address) FROM Patients a , Payment p WHERE a.Patient_ID = p.pid AND p.vid=?1")
    List<PatientsPayment> findAllPaymentByVisit(String vid);
    @Query("SELECT new com.HospitalMangagmentSystem.demo.domain.PatientsPayment(p.payment_id,a.first,a.last,p.cost,p.date,p.title,p.pid,p.vid,p.status,a.address) FROM Patients a , Payment p WHERE a.Patient_ID = p.pid AND (p.status='PAYED' OR p.status='VOIDP')")
    List<PatientsPayment> findPaymentPayed();

    @Query("SELECT new com.HospitalMangagmentSystem.demo.domain.PatientsPayment(p.payment_id,a.first,a.last,p.cost,p.date,p.title,p.pid,p.vid,p.status,a.address) FROM Patients a , Payment p WHERE a.Patient_ID = p.pid AND (p.status='NOT_PAYED' OR p.status='VOID')")
    List<PatientsPayment> findPaymentNPayed();

    @Query("SELECT new com.HospitalMangagmentSystem.demo.domain.PatientsPayment(p.payment_id,a.first,a.last,p.cost,p.date,p.title,p.pid,p.vid,p.status,a.address) FROM Patients a , Payment p WHERE a.Patient_ID = p.pid AND p.status='VOUCHER'")
    List<PatientsPayment> findPaymentVoucher();

    @Query("SELECT new com.HospitalMangagmentSystem.demo.domain.PatientsPayment(p.payment_id,a.first,a.last,p.cost,p.date,p.title,p.pid,p.vid,p.status,a.address) FROM Patients a , Payment p WHERE a.Patient_ID = p.pid AND p.status='VOID'")
    List<PatientsPayment> findPaymentVoid();
    @Query("SELECT p FROM Payment p WHERE p.vid='1' AND p.pid=?1")
    Payment findPaymentBYNameANdPid(int pid);
}
