package com.HospitalMangagmentSystem.demo.controller;


import com.HospitalMangagmentSystem.demo.Dto.PatientDto;
import com.HospitalMangagmentSystem.demo.Service.PatientService;
import com.HospitalMangagmentSystem.demo.Service.PaymentService;
import com.HospitalMangagmentSystem.demo.domain.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

    @CrossOrigin(origins = "*", maxAge = 200000)
	@RestController
	public class PatientController {

		@Autowired
		PatientService patiservice;
		PaymentService payService;

		@GetMapping("/Patient")
		public List<Patients> getPatient() {

			return this.patiservice.getallpatient();
		}
		@GetMapping("/patient/{stat}")
		public List<Patients> getbystat(@PathVariable String stat) {
			return this.patiservice.getstatus(stat);
		}
		@GetMapping("/pat/{doctorid}")
		public List<Patients> getBydType(@PathVariable int doctorid) {

			return this.patiservice.getdType(doctorid);
		}
		@GetMapping("/Patient/room/{roomNo}")
		public List<Patients> getByRoom(@PathVariable String roomNo) {

			return this.patiservice.getByRoom(roomNo);
		}
		@GetMapping("/Patient/user/{userid}")
		public List<Patients> getByUserid(@PathVariable int userid) {

			return this.patiservice.getByUserid(userid);
		}
		@GetMapping("/Patient/rooms/{room}")
		public List<Patients> getByRooms(@PathVariable String room) {

			return this.patiservice.getByRooms(room);
		}
		@GetMapping("/pat/rad/{rad}")
		public List<Patients> getByRad(@PathVariable int rad) {

			return this.patiservice.getRad(rad);
		}
		@GetMapping("/pat/rad/Tato")
		public List<Patients> getByRadTato() {

			return this.patiservice.getRadTato();
		}
		@GetMapping("/pat/lab/Tato")
		public List<Patients> getByLabTato() {
			return this.patiservice.getLabTato();
		}
		@GetMapping("/pat/lab/Tad/{doctorid}")
		public List<Patients> getByTad(@PathVariable int doctorid) {
			return this.patiservice.getTad(doctorid);
		}
		@GetMapping("/pat/lab/Tod/{doctorid}")
		public List<Patients> getByTod(@PathVariable int doctorid) {
			return this.patiservice.getTod(doctorid);
		}
		@GetMapping("/pat/rad/Tad/{doctorid}")
		public List<Patients> getByTad1(@PathVariable int doctorid) {
			return this.patiservice.getTad1(doctorid);
		}
		@GetMapping("/pat/rad/Tod/{doctorid}")
		public List<Patients> getByTod1(@PathVariable int doctorid) {
			return this.patiservice.getTod1(doctorid);
		}
		@GetMapping("/pat/lab/{lab}")
		public List<Patients> getByLab(@PathVariable int lab) {
			return this.patiservice.getLab(lab);
		}
		@GetMapping("/checkIn/{id}")
		public Patients checkInPateint(@PathVariable int id) {
			return patiservice.checkInPateint(id);
		}
		@PostMapping("/Patient/")
		@Transactional
		public ResponseEntity<Object> createpatient(@RequestBody PatientDto pdto) {
			Patients psave = this.patiservice.createpatient(pdto);
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(psave.getPatient_ID()).toUri();
			return ResponseEntity.created(location).build();



		}
		@GetMapping("/Patient/{id}")
		@Transactional
		public Patients getonepatient(@PathVariable int id) {

			return this.patiservice.getonepatient(id);

		}
		@DeleteMapping("/Patient/{id}")
		@Transactional
		public void deletepatient(@PathVariable int id) {
			this.patiservice.deletepatient(id);


		}
		@PutMapping("/Patient/{id}")
		@Transactional
		public Patients updatepatient(@RequestBody PatientDto pati, @PathVariable int id) {
			return this.patiservice.ubdatepatient(pati, id);


		}
		@PutMapping("/Patient/assign/{id}")
		@Transactional
		public Patients ubdatepatient(@RequestBody PatientDto pati, @PathVariable int id) {
			return this.patiservice.updatepatient(pati, id);


		}
		@PutMapping("/Patient/v/{id}")
		@Transactional
		public Patients ubdatePatientVisit(@RequestBody PatientDto pati, @PathVariable int id) {
			return this.patiservice.updatePatientVisit(pati, id);
		}
		@PutMapping("/Patient/Lab/{id}")
		@Transactional
		public Patients ubdatePatientLab(@RequestBody PatientDto pati, @PathVariable int id) {
			return this.patiservice.updatePatientLab(pati, id);
		}
		@PutMapping("/Patient/Rad/{id}")
		@Transactional
		public Patients ubdatePatientRad(@RequestBody PatientDto pati, @PathVariable int id) {
			return this.patiservice.updatePatientRad(pati, id);
		}
		@PutMapping("/Patient/dType/{id}")
		@Transactional
		public Patients ubdatepatientdType(@RequestBody PatientDto pati, @PathVariable int id) {
			return this.patiservice.updatepatientdType(pati, id);


		}
		@PutMapping("/Patient/opd/{id}")
		@Transactional
		public Patients ubdatepatientdTypeStatus(@RequestBody PatientDto pati, @PathVariable int id) {
			return this.patiservice.updatepatientdTypeStatus(pati, id);


		}
        @PutMapping("/Patient/Room/{id}")
        @Transactional
        public Patients addRoom(@RequestBody PatientDto pati, @PathVariable int id) {
            return this.patiservice.addRoom(pati, id);
        }
		@PutMapping("/Patient/Rooms/{id}")
		@Transactional
		public Patients addRooms(@RequestBody PatientDto pati, @PathVariable int id) {
			return this.patiservice.addRooms(pati, id);
		}
		@PutMapping("/Patient/Finish/{id}")
		@Transactional
		public Patients FinishPatient(@PathVariable int id){

			return this.patiservice.FinishPatient(id);
		}
		@PutMapping("/Patient/Payment/{id}")
		@Transactional
		public Patients updatepStatus(@RequestBody PatientDto pati, @PathVariable int id) {
			return this.patiservice.updatepStatus(pati, id);
		}

	}