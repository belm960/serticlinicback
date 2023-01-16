package com.HospitalMangagmentSystem.demo.Service;

import com.HospitalMangagmentSystem.demo.Dto.RadPriceDto;
import com.HospitalMangagmentSystem.demo.Exception.DataNotFoundException;
import com.HospitalMangagmentSystem.demo.domain.RadPrice;
import com.HospitalMangagmentSystem.demo.repository.RadPriceRespository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@JsonDeserialize
public class RadPriceServiceImplementation implements RadPriceService{
    @Autowired
    RadPriceRespository rdrep;

    @Override
    public List<RadPrice> getAll(){
        return this.rdrep.findAll();
    }

    @Override
    public RadPrice getOne(int id){
        return this.rdrep.findById(id).orElseThrow(
                ()->new DataNotFoundException("Radiology Test With id:" +id+"Not Found")
        );
    }
    @Override
    public RadPrice createTest(RadPriceDto rdt){
        RadPrice rd = new RadPrice();
        rd.setName(rdt.getName());
        rd.setPrice(rdt.getPrice());
        rd.setFinished(false);

        return this.rdrep.save(rd);
    }

    @Override
    public List<RadPrice> createTest1(RadPriceDto rdt){
        ArrayList<RadPrice> ar= new ArrayList<>();
        RadPrice rd1 = new RadPrice();
        RadPrice rd2 = new RadPrice();
        RadPrice rd3 = new RadPrice();
        RadPrice rd4 = new RadPrice();
        RadPrice rd5 = new RadPrice();
        RadPrice rd6 = new RadPrice();
        RadPrice rd7 = new RadPrice();
        rd1.setName("X-Ray");
        rd1.setPrice(250.00);
        rd1.setFinished(false);
        rd2.setName("Echocardiography");
        rd2.setPrice(250.00);
        rd2.setFinished(false);
        rd3.setName("Abdominal Ultrasound");
        rd3.setPrice(250.00);
        rd3.setFinished(false);
        rd4.setName("Pelvic Ultrasound ");
        rd4.setPrice(250.00);
        rd4.setFinished(false);
        rd5.setName("Obstetric Ultrasound");
        rd5.setPrice(250.00);
        rd5.setFinished(false);
        rd6.setName("Other Ultrasound");
        rd6.setPrice(250.00);
        rd6.setFinished(false);
        rd7.setName("ECG");
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
    public RadPrice updateTest(RadPriceDto rdt,int id){
        RadPrice rd  = this.rdrep.findById(id).orElseThrow(
                ()->new DataNotFoundException("Radiology with id:"+id+"does not found")
        );
        rd.setPrice(rdt.getPrice());
        return this.rdrep.save(rd);
    }

    @Override
    public void deleteTest(int id){
        this.rdrep.deleteById(id);
    }
}
