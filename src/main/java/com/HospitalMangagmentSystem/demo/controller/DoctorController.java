package com.HospitalMangagmentSystem.demo.controller;


import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DoctorController {

	/**@Autowired
	DoctorService docservice;
	
	@GetMapping("/Doctor")
	public List<Doctor> getDoctor(){
	
		return this.docservice.getalldoctor();
	}
	
	@PostMapping("/Doctor")
	@Transactional
	public ResponseEntity<Object> createDoctor(@RequestBody DoctorDto doc) {
		Doctor docsave = this.docservice.createdoctor(doc);
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(docsave.getDoctor_ID()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@GetMapping("/Doctor/{id}")
	@Transactional
	public Doctor getoneDoctor(@RequestBody DoctorDto Doctordto , @PathVariable int id) {
		
		return docservice.getonedoctor(id);
		
		
	}
	
	@DeleteMapping("/Doctor/{id}")
	@Transactional
	public void deleteDoctor( @PathVariable int id) {
		this.docservice.deletedoctor(id);
		
	}
	
	@PutMapping("/Doctor/{id}")
	@Transactional
	public Doctor updateDoctor(@RequestBody Doctor doc , @PathVariable int id) {
		
		
		return this.docservice.ubdatedoctor(doc, id);
		
	}*/

}
