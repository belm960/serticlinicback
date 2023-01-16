package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.PatientDto;
import com.HospitalMangagmentSystem.demo.domain.Patients;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@JsonDeserialize
public interface PatientService {
	List<Patients> getallpatient();
	List<Patients> getstatus(String stat);
	List<Patients> getdType(int docid);
	List<Patients> getByRoom(String roomNo);
	List<Patients> getByUserid(int userid);
	List<Patients> getByRooms(String room);
	List<Patients> getLab(int lab);
	List<Patients> getRad(int rad);
	List<Patients> getRadTato();
	List<Patients> getLabTato();
	List<Patients> getTad(int doctorid);
	List<Patients> getTod(int doctorid);
	List<Patients> getTad1(int doctorid);
	List<Patients> getTod1(int doctorid);
	Patients checkInPateint(int id);
	Patients getonepatient(int id);
	Patients createpatient(PatientDto pati);
	void deletepatient(int id);
	Patients ubdatepatient(PatientDto pati , int id);
	Patients updatepatient(PatientDto pati , int id);
	Patients updatePatientVisit(PatientDto pati , int id);
	Patients updatePatientLab(PatientDto pati , int id);
	Patients updatePatientRad(PatientDto pati , int id);
	Patients updatepatientdType(PatientDto pati , int id);
	Patients updatepatientdTypeStatus(PatientDto pati , int id);
	Patients addRoom(PatientDto pati,int id);
	Patients addRooms(PatientDto patientDto, int id);
	Patients FinishPatient(int id);
	Patients updatepStatus(PatientDto patientDto, int id);
}
