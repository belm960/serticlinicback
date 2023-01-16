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
        rd1.setName("WBC count");
        rd1.setPrice(250.00);
        rd1.setFinished(false);
        rd2.setName("Differential Count");
        rd2.setPrice(250.00);
        rd2.setFinished(false);
        rd3.setName("Haemoglobin");
        rd3.setPrice(250.00);
        rd3.setFinished(false);
        rd4.setName("Hematocrit");
        rd4.setPrice(250.00);
        rd4.setFinished(false);
        rd5.setName("Platelet count");
        rd5.setPrice(250.00);
        rd5.setFinished(false);
        rd6.setName("CBC");
        rd6.setPrice(250.00);
        rd6.setFinished(false);
        rd7.setName("ESR");
        rd7.setPrice(250.00);
        rd7.setFinished(false);
        ar.add(rd1);
        ar.add(rd2);
        ar.add(rd3);
        ar.add(rd4);
        ar.add(rd5);
        ar.add(rd6);
        ar.add(rd7);
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
