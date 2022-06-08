package com.covid.vaccination.Controller;

import com.covid.vaccination.DTO.DoctorDTO;
import com.covid.vaccination.Implementation.DoctorLoginImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorLoginController {

    @Autowired
    private DoctorLoginImpl doctorloginImpl;

    @PostMapping(value = "/doctorlogin")
    public ResponseEntity<String> logInDoctor(@RequestBody DoctorDTO doctorDTO) {
        return new ResponseEntity<>(doctorloginImpl.logIntoAccount(doctorDTO), HttpStatus.CHECKPOINT);
    }

    // for user Logout
    @PatchMapping(value = "/doctorlogout")
    public ResponseEntity<String> logOutDoctor(@RequestParam String key) {
        return new ResponseEntity<>(doctorloginImpl.logOutFromAccount(key),HttpStatus.CHECKPOINT);
    }

}
