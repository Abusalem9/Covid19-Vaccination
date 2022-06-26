package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.DoctorLogin;
import com.covid.vaccination.Entity.UserLogin;
import org.springframework.stereotype.Service;


public interface DoctorLoginService {
    public DoctorLogin login(DoctorLogin doctorLogin);
    public String logOut(DoctorLogin doctorLogin);
}
