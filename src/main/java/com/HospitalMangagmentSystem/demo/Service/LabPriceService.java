package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.LabPriceDto;
import com.HospitalMangagmentSystem.demo.domain.LabPrice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LabPriceService {
    List<LabPrice> getAll();

    LabPrice getOne(int id);

    LabPrice createTest(LabPriceDto rd);
    List<LabPrice> createTest1(LabPriceDto rd);

    void deleteTest(int id);

    LabPrice updateTest(LabPriceDto rd , int id);
}
