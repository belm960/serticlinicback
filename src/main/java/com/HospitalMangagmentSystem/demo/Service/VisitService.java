package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.VisitDto;
import com.HospitalMangagmentSystem.demo.domain.Visit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VisitService {

    List<Visit> getbypid(String pid);

    Visit getonevisit(String id);

    Visit createvisit(VisitDto vis);

    void deletevisit(String id);

    Visit updatevisit(VisitDto vis , String id);


}
