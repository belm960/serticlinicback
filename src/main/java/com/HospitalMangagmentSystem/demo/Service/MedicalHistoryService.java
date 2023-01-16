package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.MedicalHistoryDto;
import com.HospitalMangagmentSystem.demo.domain.MedicalHistory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedicalHistoryService {
    List <MedicalHistory> getallmedicalhistory();

    MedicalHistory getonemedicalhistory(int id);

    MedicalHistory createmedicalhistory(MedicalHistoryDto mhdto,int id);

    void deletemedicalhistory(int id);

    MedicalHistory updatemedicalhistory(MedicalHistoryDto mhdto, int id);



}
