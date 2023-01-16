package com.HospitalMangagmentSystem.demo.Service;


import com.HospitalMangagmentSystem.demo.Dto.StaffDto;
import com.HospitalMangagmentSystem.demo.domain.Staff;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StaffService {

    List<Staff> getAllStaff();

    Staff getOneStaff(int id);

    Staff createStaff(StaffDto sdt);

    void deleteStaff(int id);

    Staff updateStaff(StaffDto sdt , int id);


}
