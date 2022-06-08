package com.covid.vaccination.Service;

import com.covid.vaccination.DTO.DoctorDTO;
import com.covid.vaccination.Entity.Doctor;
import org.springframework.http.ResponseEntity;

import javax.print.Doc;

public interface DoctorLogin {

    String logIntoAccount(DoctorDTO doctorDTO);

    String logOutFromAccount(String key);

}
