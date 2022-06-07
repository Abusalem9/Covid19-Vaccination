package com.covid.vaccination.Service;

import com.covid.vaccination.DTO.DoctorDTO;

public interface DoctorLogin {

    String logIntoAccount(DoctorDTO doctorDTO);

    String logOutFromAccount(String key);
}
