package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Dto.DoctorDto;
import com.HospitalMangagmentSystem.demo.Dto.VisitBasic;
import com.HospitalMangagmentSystem.demo.Dto.VisitNote;
import com.HospitalMangagmentSystem.demo.domain.User;
import org.springframework.stereotype.Service;

import com.HospitalMangagmentSystem.demo.Dto.DoctorvisitDto;
import com.HospitalMangagmentSystem.demo.domain.DoctorsVisit;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Service
@JsonDeserialize 
public interface DoctorvisitService {
	List<DoctorsVisit> getCheckedInPatients();

	void dischargePateint(int id);
	User addDoctorInAvisit(DoctorDto doc, int i);

	DoctorsVisit getEncounterBy(int id);

	DoctorsVisit addEncounterBasic(VisitBasic basic, int i);

	DoctorsVisit addEncounterNote(VisitNote note, int id);

	List<DoctorsVisit> getVisitbyPatientid(int id);

	DoctorsVisit createvisit(DoctorvisitDto dvDto);
}
