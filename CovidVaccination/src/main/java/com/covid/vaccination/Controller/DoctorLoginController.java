package com.covid.vaccination.Controller;

import com.covid.vaccination.DTO.DoctorDTO;
import com.covid.vaccination.Implementation.DoctorLoginImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorLoginController {

    @Autowired
    private DoctorLoginImpl doctorloginImpl;

    @PostMapping(value = "/doctorlogin")
    public String logInDoctor(@RequestBody DoctorDTO doctorDTO) {
        return doctorloginImpl.logIntoAccount(doctorDTO);
    }

    // for user Logout
    @PatchMapping(value = "/doctorlogout")
    public String logOutDoctor(@RequestParam String key) {
        return doctorloginImpl.logOutFromAccount(key);
    }

}
