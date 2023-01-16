package com.HospitalMangagmentSystem.demo.Service;

import java.util.List;

import com.HospitalMangagmentSystem.demo.Dto.DoctorDto;
import com.HospitalMangagmentSystem.demo.Dto.DoctorvisitDto;
import com.HospitalMangagmentSystem.demo.Dto.VisitBasic;
import com.HospitalMangagmentSystem.demo.Dto.VisitNote;
import com.HospitalMangagmentSystem.demo.domain.DoctorsVisit;
import com.HospitalMangagmentSystem.demo.domain.User;
import com.HospitalMangagmentSystem.demo.constants.MedicalUtil;
import com.HospitalMangagmentSystem.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HospitalMangagmentSystem.demo.repository.DoctorVisitRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.transaction.annotation.Transactional;

@Component
@JsonDeserialize 
public class DoctorvisitserviceImplentation implements DoctorvisitService {
	@Autowired
	DoctorVisitRepository encounterRepo;
    @Autowired
	UserRepository userrepo;
	@Autowired
	DoctorVisitRepository dvrep;
	@Override
	public List<DoctorsVisit> getCheckedInPatients() {
		return encounterRepo.findByStatusNot(MedicalUtil.ENCOUNTER_STATUS_COMPLETED);
	}



	@Override
	public void dischargePateint(int id) {
		DoctorsVisit encounter = encounterRepo.findById(id).orElse(null);
		if(encounter != null) {
			encounter.setStatus(MedicalUtil.ENCOUNTER_STATUS_COMPLETED);
			encounterRepo.save(encounter);
		}

	}

	@Override
	@Transactional
	public User addDoctorInAvisit(DoctorDto doc, int id) {

		String doctorsname = doc.getDoctorsname();
		System.out.println(doctorsname);
		String delims = "[ ]+";
		String[] tokens = doctorsname.split(delims);
		String firstName = tokens[0];
		String lastName = tokens[1];
		System.out.println(lastName);
		System.out.println(firstName);
		User user = userrepo.findByLastAndFirst(lastName,firstName);


		DoctorsVisit visit  = encounterRepo.findById(id).orElse(null);
		System.out.println(visit.getStatus());
		user.addDoctor(visit);

		    // user.setEncounter(visit);
		// add the appointment into the doctor
		return userrepo.save(user);


	}

	@Override
	public DoctorsVisit getEncounterBy(int id) {
		return encounterRepo.findById(id).orElse(null);
	}





	@Override
	public DoctorsVisit addEncounterBasic(VisitBasic encounter, int id) {
		//Optional<Visit> enc = Optional.ofNullable(encounterRepo.findByEncounterid(id));
		//Visit visit = enc.get();
		// System.out.println(visit.getPulse());
		DoctorsVisit enc =  encounterRepo.findById(id).orElse(null);

		// Optional<Iterable<Visit>> vehicle = this,encounterRepo.findById(id);
		//Visit enc =encounterRepo.findById(id).orElseThrow(()->
		//  new DataNotFoundException("patient with id " + id + " not found") )

		enc.setStatus(MedicalUtil.ENCOUNTER_STATUS_IN_PROGRESS);
		enc.setPulse(encounter.getPulse());
		enc.setTemp(encounter.getTemp());
		enc.setSat(encounter.getSat());
		//enc.setRespRate(encounter.getRespRate());
		enc.setWeight(encounter.getWeight());


		enc.setPulse(encounter.getPulse());
		return encounterRepo.save(enc);
	}

	@Override
	public DoctorsVisit addEncounterNote(VisitNote note, int id) {
		DoctorsVisit enc =  encounterRepo.findById(id).orElse(null);
		enc.setRemark(note.getRemark());
		enc.setTreatment(note.getTreatment());
		enc.setChiefComplaint(note.getChiefComplaint());
		return  encounterRepo.save(enc);

	}

	@Override
	public List<DoctorsVisit> getVisitbyPatientid(int id) {
			return dvrep.findByPatientId(id);
		}
	@Override
	public DoctorsVisit createvisit(DoctorvisitDto dvDto) {

		DoctorsVisit dov =new DoctorsVisit();
		dov.setTitle(dvDto.getTitle());
		dov.setVisitDate(dvDto.getVisitDate());
		dov.setDoctorName(dvDto.getDoctorName());
		dov.setNote_Details(dvDto.getNote_Details());
		dov.setLabDiagnosis(dvDto.getLabDiagnosis());
		dov.setRadDiagnosis(dvDto.getRadDiagnosis());
		dov.setPid(dvDto.getPid());

		return dvrep.save(dov);
	}

}
