package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.RadPriceDto;
import com.HospitalMangagmentSystem.demo.domain.RadPrice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RadPriceService {
    List<RadPrice> getAll();

    RadPrice getOne(int id);

    RadPrice createTest(RadPriceDto rd);
    List<RadPrice> createTest1(RadPriceDto rd);

    void deleteTest(int id);

    RadPrice updateTest(RadPriceDto rd , int id);
}
