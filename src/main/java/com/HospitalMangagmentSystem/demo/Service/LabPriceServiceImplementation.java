package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.LabPriceDto;
import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import com.HospitalMangagmentSystem.demo.domain.LabPrice;
import com.HospitalMangagmentSystem.demo.repository.LabPriceRespository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@JsonDeserialize
public class LabPriceServiceImplementation implements LabPriceService{
    @Autowired
    LabPriceRespository rdrep;

    @Override
    public List<LabPrice> getAll(){
        return this.rdrep.findAll();
    }

    @Override
    public LabPrice getOne(int id){
        return this.rdrep.findById(id).orElseThrow(
                ()->new DataNotFoundException("Laboratory Test With id:" +id+"Not Found")
        );
    }
    @Override
    public LabPrice createTest(LabPriceDto rdt){
        LabPrice rd = new LabPrice();
        rd.setName(rdt.getName());
        rd.setPrice(rdt.getPrice());
        rd.setFinished(false);

        return this.rdrep.save(rd);
    }

    @Override
    public List<LabPrice> createTest1(LabPriceDto rdt){
        ArrayList<LabPrice> ar= new ArrayList<>();
        LabPrice rd1 = new LabPrice();
        LabPrice rd2 = new LabPrice();
        LabPrice rd3 = new LabPrice();
        LabPrice rd4 = new LabPrice();
        LabPrice rd5 = new LabPrice();
        LabPrice rd6 = new LabPrice();
        LabPrice rd7 = new LabPrice();
        LabPrice rd8 = new LabPrice();
        LabPrice rd9 = new LabPrice();
        LabPrice rd10 = new LabPrice();
        LabPrice rd11 = new LabPrice();
        LabPrice rd12 = new LabPrice();
        LabPrice rd13 = new LabPrice();
        LabPrice rd14 = new LabPrice();
        LabPrice rd15 = new LabPrice();
        LabPrice rd16 = new LabPrice();
        LabPrice rd17 = new LabPrice();
        LabPrice rd18 = new LabPrice();
        LabPrice rd19 = new LabPrice();
        LabPrice rd20 = new LabPrice();
        LabPrice rd21 = new LabPrice();
        LabPrice rd22 = new LabPrice();
        LabPrice rd23 = new LabPrice();
        LabPrice rd24 = new LabPrice();
        LabPrice rd25 = new LabPrice();
        LabPrice rd26 = new LabPrice();
        LabPrice rd27 = new LabPrice();
        LabPrice rd28 = new LabPrice();
        LabPrice rd29 = new LabPrice();
        LabPrice rd30 = new LabPrice();
        LabPrice rd31 = new LabPrice();
        LabPrice rd32 = new LabPrice();
        LabPrice rd33 = new LabPrice();
        LabPrice rd34 = new LabPrice();
        LabPrice rd35 = new LabPrice();
        LabPrice rd36 = new LabPrice();
        LabPrice rd37 = new LabPrice();
        LabPrice rd38 = new LabPrice();
        LabPrice rd39 = new LabPrice();
        LabPrice rd40 = new LabPrice();
        LabPrice rd41 = new LabPrice();
        LabPrice rd42 = new LabPrice();
        LabPrice rd43 = new LabPrice();
        LabPrice rd44 = new LabPrice();
        LabPrice rd45= new LabPrice();
        LabPrice rd46= new LabPrice();
        LabPrice rd47= new LabPrice();
        LabPrice rd48= new LabPrice();
        LabPrice rd49= new LabPrice();
        LabPrice rd50= new LabPrice();
        LabPrice rd51= new LabPrice();
        LabPrice rd52= new LabPrice();
        LabPrice rd53= new LabPrice();
        LabPrice rd54= new LabPrice();
        LabPrice rd55= new LabPrice();
        LabPrice rd56= new LabPrice();
        LabPrice rd57= new LabPrice();
        
        rd1.setName("WBC count");rd1.setPrice(250.00);rd1.setFinished(false);
        rd2.setName("Differential Count");rd2.setPrice(250.00);rd2.setFinished(false);
        rd3.setName("Haemoglobin");rd3.setPrice(250.00);rd3.setFinished(false);
        rd4.setName("Hematocrit");rd4.setPrice(250.00);rd4.setFinished(false);
        rd5.setName("Platelet count");rd5.setPrice(250.00);rd5.setFinished(false);
        rd6.setName("CBC");rd6.setPrice(250.00);rd6.setFinished(false);
        rd7.setName("ESR");rd7.setPrice(250.00);rd7.setFinished(false);
        rd8.setName("Blood Film");rd8.setPrice(250.00);rd8.setFinished(false);
        rd9.setName("Blood Group");rd9.setPrice(250.00);rd9.setFinished(false);
        rd10.setName("FBS/RBS");rd10.setPrice(250.00);rd10.setFinished(false);
        rd11.setName("HCG");rd11.setPrice(250.00);rd11.setFinished(false);
        rd12.setName("HBSAg");rd12.setPrice(250.00);rd12.setFinished(false);
        rd13.setName("HBV");rd13.setPrice(250.00);rd13.setFinished(false);
        rd14.setName("Hemoglobin");rd14.setPrice(250.00);rd14.setFinished(false);
        rd15.setName("H.Paylori(Ab. test)");rd15.setPrice(250.00);rd15.setFinished(false);
        rd16.setName("H.paylori(Ag. test)");rd16.setPrice(250.00);rd16.setFinished(false);
        rd17.setName("Stool Exam");rd17.setPrice(250.00);rd17.setFinished(false);
        rd18.setName("Sputum Test");rd18.setPrice(250.00);rd18.setFinished(false);
        rd19.setName("UrinAnalysis");rd19.setPrice(250.00);rd19.setFinished(false);
        rd20.setName("VDRL/RPR");rd20.setPrice(250.00);rd20.setFinished(false);
        rd21.setName("Weilflex");rd21.setPrice(250.00);rd21.setFinished(false);
        rd22.setName("Widal Test");rd22.setPrice(250.00);rd22.setFinished(false);
        rd23.setName("Uric Acid");rd23.setPrice(250.00);rd23.setFinished(false);
        rd24.setName("Rheumatoid Factor (RF)");rd24.setPrice(250.00);rd24.setFinished(false);
        rd25.setName("Viral Load VL(Referal)");rd25.setPrice(250.00);rd25.setFinished(false);
        rd26.setName("CD4 (Referal)");rd26.setPrice(250.00);rd26.setFinished(false);
        rd27.setName("DBS (referal)");rd27.setPrice(250.00);rd27.setFinished(false);
        rd28.setName("G-xpert (referal)");rd28.setPrice(250.00);rd28.setFinished(false);
        rd29.setName("Covid 19 test");rd29.setPrice(250.00);rd29.setFinished(false);
        rd30.setName("GOT/AST-Aspartate Amino transfererase");rd30.setPrice(250.00);rd30.setFinished(false);
        rd31.setName("GPT/ALT- alanine trans aminase");rd31.setPrice(250.00);rd31.setFinished(false);
        rd32.setName("ALP alkaline phosphate");rd32.setPrice(250.00);rd32.setFinished(false);
        rd33.setName("Bil direct");rd33.setPrice(250.00);rd33.setFinished(false);
        rd34.setName("Biliru Total");rd34.setPrice(250.00);rd34.setFinished(false);
        rd35.setName("creatinine");rd35.setPrice(250.00);rd35.setFinished(false);
        rd36.setName("Urea");rd36.setPrice(250.00);rd36.setFinished(false);
        rd37.setName("Uric Acid");rd37.setPrice(250.00);rd37.setFinished(false);
        rd38.setName("Cholstrol");rd38.setPrice(250.00);rd38.setFinished(false);
        rd39.setName("Glucose");rd39.setPrice(250.00);rd39.setFinished(false);
        rd40.setName("Total Protein");rd40.setPrice(250.00);rd40.setFinished(false);
        rd41.setName("Triglyceride");rd41.setPrice(250.00);rd41.setFinished(false);
        rd42.setName("CBC");rd42.setPrice(250.00);rd42.setFinished(false);
        rd43.setName("WBC");rd43.setPrice(250.00);rd43.setFinished(false);
        rd44.setName("Neutrophill");rd44.setPrice(250.00);rd44.setFinished(false);
        rd45.setName("Lymphocyte");rd45.setPrice(250.00);rd45.setFinished(false);
        rd46.setName("MonoCyte");rd46.setPrice(250.00);rd46.setFinished(false);
        rd47.setName("Eosinophil");rd47.setPrice(250.00);rd47.setFinished(false);
        rd48.setName("Basophil");rd48.setPrice(250.00);rd48.setFinished(false);
        rd49.setName("RBC");rd49.setPrice(250.00);rd49.setFinished(false);
        rd50.setName("Hemoglobin");rd50.setPrice(250.00);rd50.setFinished(false);
        rd51.setName("Hematocrite");rd51.setPrice(250.00);rd51.setFinished(false);
        rd52.setName("platlet");rd52.setPrice(250.00);rd52.setFinished(false);
        rd53.setName("MCV");rd53.setPrice(250.00);rd53.setFinished(false);
        rd54.setName("MCHC");rd54.setPrice(250.00);rd54.setFinished(false);
        rd55.setName("MCH");rd55.setPrice(250.00);rd55.setFinished(false);
        rd56.setName("RDW");rd56.setPrice(250.00);rd56.setFinished(false);
        rd57.setName("ASO (anti streptolysin o)");rd57.setPrice(250.00);rd57.setFinished(false);

        ar.add(rd1);
        ar.add(rd2);
        ar.add(rd3);
        ar.add(rd4);
        ar.add(rd5);
        ar.add(rd6);
        ar.add(rd7);
        ar.add(rd8);
        ar.add(rd9);
        ar.add(rd10);
        ar.add(rd11);
        ar.add(rd12);
        ar.add(rd13);
        ar.add(rd14);
        ar.add(rd15);
        ar.add(rd16);
        ar.add(rd17);
        ar.add(rd18);
        ar.add(rd19);
        ar.add(rd20);
        ar.add(rd21);
        ar.add(rd22);
        ar.add(rd23);
        ar.add(rd24);
        ar.add(rd25);
        ar.add(rd26);
        ar.add(rd27);
        ar.add(rd28);
        ar.add(rd29);
        ar.add(rd30);
        ar.add(rd31);
        ar.add(rd32);
        ar.add(rd33);
        ar.add(rd34);
        ar.add(rd35);
        ar.add(rd36);
        ar.add(rd37);
        ar.add(rd38);
        ar.add(rd39);
        ar.add(rd40);
        ar.add(rd41);
        ar.add(rd42);
        ar.add(rd43);
        ar.add(rd44);
        ar.add(rd45);
        ar.add(rd46);
        ar.add(rd47);
        ar.add(rd48);
        ar.add(rd49);
        ar.add(rd50);
        ar.add(rd51);
        ar.add(rd52);
        ar.add(rd53);
        ar.add(rd54);
        ar.add(rd55);
        ar.add(rd56);
        ar.add(rd57);
        return this.rdrep.saveAll(ar);
    }

    @Override
    public LabPrice updateTest(LabPriceDto rdt,int id){
        LabPrice rd  = this.rdrep.findById(id).orElseThrow(
                ()->new DataNotFoundException("Laboratory with id:"+id+"does not found")
        );
        rd.setPrice(rdt.getPrice());
        return this.rdrep.save(rd);
    }

    @Override
    public void deleteTest(int id){
        this.rdrep.deleteById(id);
    }
}
