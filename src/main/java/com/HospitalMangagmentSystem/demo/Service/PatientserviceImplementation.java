package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.PatientDto;
import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import com.HospitalMangagmentSystem.demo.constants.MedicalUtil;
import com.HospitalMangagmentSystem.demo.domain.DoctorsVisit;
import com.HospitalMangagmentSystem.demo.domain.Patients;
import com.HospitalMangagmentSystem.demo.repository.PatientRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@JsonDeserialize
public class PatientserviceImplementation implements PatientService {

    @Autowired
    PatientRepository patrep;

    @Override
	public List<Patients> getallpatient() {
		// TODO Auto-generated method stub
		return patrep.findAll();
	}
	@Override
	public List<Patients> getstatus(String stat){
		return patrep.findByName(stat);
	}
	@Override
	public List<Patients> getdType(int docid){
		return patrep.findByNames(docid);
	}
	@Override
	public List<Patients> getByRoom(String roomNo){
		return patrep.findByRoom(roomNo);
	}
	@Override
	public List<Patients> getByUserid(int userid){
		return patrep.findByUserid(userid);
	}
	@Override
	public List<Patients> getByRooms(String room){
		return patrep.findByRooms(room);
	}
	@Override
	public List<Patients> getLab(int lab){
		return patrep.findByNamesLab(lab);
	}
	@Override
	public List<Patients> getRad(int rad){
		return patrep.findByNamesRad(rad);
	}
	@Override
	public List<Patients> getRadTato(){
		return patrep.findByNamesRadTato();
	}
	@Override
	public List<Patients> getLabTato(){
		return patrep.findByNamesLabTato();
	}
	@Override
	public List<Patients> getTad(int doctorid){
		return patrep.findByNamesTad(doctorid);
	}
	@Override
	public List<Patients> getTod(int doctorid){
		return patrep.findByNamesTod(doctorid);
	}
	@Override
	public List<Patients> getTad1(int doctorid){
		return patrep.findByNamesTad(doctorid);
	}
	@Override
	public List<Patients> getTod1(int doctorid){
		return patrep.findByNamesTod(doctorid);
	}
	@Override
	public Patients getonepatient(int id) {
		// TODO Auto-generated method stub
		Patients pp =patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );

		return pp;
	}
	@Override
	public Patients checkInPateint(int id) {
		Patients patient = patrep.findById(id).orElse(null);

		DoctorsVisit encounter = new DoctorsVisit();
		encounter.setCheckInDateTime(new Date());
		encounter.setPatient(patient);
		encounter.setStatus(MedicalUtil.ENCOUNTER_STATUS_OPEN);

		//User employee = patrep.findById(1).orElse(null); // need to be fixed
		//encounter.setEmployee(employee);

		//encounterRepo.save(encounter);

		patient.addEncounter(encounter);
		patient = patrep.save(patient);

		return patient;
	}
	@Override
	public Patients createpatient(PatientDto patientDto) {

		Patients patient = new Patients();

		patient.setFirst(patientDto.getFirst());
		patient.setLast(patientDto.getLast());
		patient.setGender(patientDto.getGender());
		patient.setDob(patientDto.getDob());
		patient.setEmail(patientDto.getEmail());
		patient.setMobile(patientDto.getMobile());
		patient.setAge(patientDto.getAge());
		patient.setStatus(patientDto.getStatus());
		patient.setUserid(patientDto.getUserid());
		patient.setAddress(patientDto.getAddress());

		return patrep.save(patient);
	}
	@Override
	public void deletepatient(int id) {
		// TODO Auto-generated method stub
		Patients patient = patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		patrep.delete(patient);
	}
	@Override
	public Patients ubdatepatient(PatientDto patientDto, int id) {
		// TODO Auto-generated method stub
		Patients patient =patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		patient.setFirst(patientDto.getFirst());
		patient.setLast(patientDto.getLast());
		patient.setGender(patientDto.getGender());
		patient.setDob(patientDto.getDob());
		patient.setEmail(patientDto.getEmail());
		patient.setMobile(patientDto.getMobile());
		patient.setAddress(patientDto.getAddress());

		return patrep.save(patient);


	}
	@Override
	public Patients updatepatient(PatientDto patientDto, int id) {
		// TODO Auto-generated method stub
		Patients patient =patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		patient.setStatus(patientDto.getStatus());
		patient.setSortDate(patientDto.getSortDate());
		return patrep.save(patient);


	}
	@Override
	public Patients updatePatientVisit(PatientDto patientDto, int id) {
		// TODO Auto-generated method stub
		Patients patient =patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		patient.setV(patientDto.getV());
		patient.setSortDate(patientDto.getSortDate());
		patient.setStatus(patientDto.getStatus());
		return patrep.save(patient);


	}
	@Override
	public Patients updatePatientLab(PatientDto patientDto, int id) {
		// TODO Auto-generated method stub
		Patients patient =patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		patient.setLab(patientDto.getLab());
		patient.setSortDate(patientDto.getSortDate());
		return patrep.save(patient);
	}
	@Override
	public Patients updatePatientRad(PatientDto patientDto, int id) {
		// TODO Auto-generated method stub
		Patients patient =patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		patient.setRad(patientDto.getRad());
		patient.setSortDate(patientDto.getSortDate());
		return patrep.save(patient);


	}
	@Override
	public Patients updatepatientdType(PatientDto patientDto, int id) {
		// TODO Auto-generated method stub
		Patients patient =patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		patient.setDoctorid(patientDto.getDoctorid());
		patient.setSortDate(patientDto.getSortDate());
		return patrep.save(patient);


	}
	@Override
	public Patients updatepatientdTypeStatus(PatientDto patientDto, int id) {
		// TODO Auto-generated method stub
		Patients patient =patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		patient.setDoctorid(patientDto.getDoctorid());
		patient.setStatus(patientDto.getStatus());
		patient.setSortDate(patientDto.getSortDate());
		return patrep.save(patient);


	}

	@Override
	public Patients addRoom(PatientDto patientDto, int id) {
		// TODO Auto-generated method stub
		Patients patient =patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		patient.setRoomNo(patientDto.getRoomNo());
		patient.setRoom(patientDto.getRoom());
		return patrep.save(patient);


	}
	@Override
	public Patients addRooms(PatientDto patientDto, int id) {
		// TODO Auto-generated method stub
		Patients patient =patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		patient.setRoom(patientDto.getRoom());
		return patrep.save(patient);


	}
	@Override
	public Patients FinishPatient(int id) {
		// TODO Auto-generated method stub
		Patients patient =patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		patient.setLab(0);
		patient.setRad(0);
		patient.setdType("none");
		patient.setStatus("none");
		patient.setDoctorid(0);
		return patrep.save(patient);
	}
	@Override
	public Patients updatepStatus(PatientDto patientDto, int id) {
		// TODO Auto-generated method stub
		Patients patient =patrep.findById(id).orElseThrow(()->
				new DataNotFoundException("patient with id " + id + " not found") );
		patient.setpStatus(patientDto.getpStatus());
		return patrep.save(patient);


	}

}
