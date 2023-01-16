package com.HospitalMangagmentSystem.demo.Service;


import com.HospitalMangagmentSystem.demo.Dto.RadiologyDto;
import com.HospitalMangagmentSystem.demo.domain.Radiology;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RadiologyService {


    List<Radiology> getallRadiology();

    Radiology getoneRadiology(int id);

    List<Radiology> getoneRadiologyByVisit(String vid);

    Radiology createRadiology(RadiologyDto lab);

        void deleteRadiology(int id);

    Radiology ubdateRadiology(RadiologyDto raddto , int id);
}
