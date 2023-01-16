package com.HospitalMangagmentSystem.demo.Service;


        import com.HospitalMangagmentSystem.demo.Dto.LaboratoryDto;

        import com.HospitalMangagmentSystem.demo.domain.Laboratory;
        import org.springframework.stereotype.Service;

        import java.util.List;
@Service
public interface LaboratoryService {

    List<Laboratory> getallLaboratories();

    Laboratory getonelaboratory(int id);

    List<Laboratory> getoneLaboratoryByVisit(String vid);

    Laboratory createLaboratory(LaboratoryDto lab);

    void deleteLaboratory(int id);

    Laboratory ubdateLaboratory(LaboratoryDto labdto , int id);
}
