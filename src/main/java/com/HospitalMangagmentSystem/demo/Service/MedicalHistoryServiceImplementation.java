package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.MedicalHistoryDto;
import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import com.HospitalMangagmentSystem.demo.domain.MedicalHistory;
import com.HospitalMangagmentSystem.demo.domain.Patients;
import com.HospitalMangagmentSystem.demo.repository.MedicalHistoryRepository;
import com.HospitalMangagmentSystem.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicalHistoryServiceImplementation implements MedicalHistoryService{

    @Autowired
    MedicalHistoryRepository medrep;
    @Autowired
    PatientRepository patrep;

    @Override
    public List<MedicalHistory> getallmedicalhistory(){
        return this.medrep.findAll();
    }

    @Override
    public MedicalHistory getonemedicalhistory(int id){
        MedicalHistory mhist=medrep.findById(id).orElseThrow(()->
                new DataNotFoundException("Medical History with id " + id + " not found") );
        return mhist;
    }

    @Override
    public MedicalHistory createmedicalhistory(MedicalHistoryDto mhdto,int id){

        Patients pat = patrep.findById(id).orElse(null);

        MedicalHistory mhist=  new MedicalHistory();

        mhist.setDescription(mhdto.getDescription());
        mhist.setDiagnosis(mhdto.getDiagnosis());
        mhist.setDiagnosis_code(mhdto.getDiagnosis_code());
        mhist.setOnset_date(mhdto.getOnset_date());
        mhist.setRecord_type(mhdto.getRecord_type());
        mhist.setDiagnosisNotes(mhdto.getDiagnosisNotes());
        mhist.setDiseaseCatagory(mhdto.getDiseaseCatagory());
        pat.addMedicalHistory(mhist);
        
        return medrep.save(mhist);
    }

    @Override
    public void deletemedicalhistory(int id) {
        medrep.deleteById(id);
    }


    @Override
    public MedicalHistory updatemedicalhistory(MedicalHistoryDto mhdto, int id) {
        MedicalHistory mhis = medrep.findById(id).orElseThrow(()->
                new DataNotFoundException("Medical History with id " + id + " not found") );

        mhis.setDescription(mhdto.getDescription());
        mhis.setDiagnosis(mhdto.getDiagnosis());
        mhis.setDiagnosis_code(mhdto.getDiagnosis_code());
        mhis.setOnset_date(mhdto.getOnset_date());
        mhis.setRecord_type(mhdto.getRecord_type());
        mhis.setDiagnosisNotes(mhdto.getDiagnosisNotes());
        mhis.setDiseaseCatagory(mhdto.getDiseaseCatagory());
        mhis.setPatient(mhis.getPatient());
        return this.medrep.save(mhis);
    }


}
