package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Entity.DoctorLogin;
import com.covid.vaccination.Implementation.DoctorLoginServiceImpl;
import com.covid.vaccination.Implementation.DoctorServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class DoctorController {

    @Autowired

    private DoctorServicesImp dsi;
    
   

    @PostMapping("/addDoctor")
    public String createDoctor(@RequestBody Doctor doctor){
        dsi.addDoctor(doctor);
        return "Doctor Has Been Added Successfully.";
    }

    @Autowired
    public DoctorLoginServiceImpl doctorLoginService;
    @PostMapping("/Doctor/Login")
    public DoctorLogin userLogin(@RequestBody DoctorLogin userLogin) {
        return doctorLoginService.login(userLogin);
    }

    @PostMapping("/Doctor/Logout")
    public String DoctorLogOut(@RequestBody DoctorLogin userLogin) {
        return doctorLoginService.logOut(userLogin);
    }
    @GetMapping("/profile")
    public ResponseEntity<Doctor> viewProfile(@RequestParam String key) {
        return  dsi.viewProfile(key);
    }

    @PutMapping("/updateDoctor")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor, @RequestParam String password) throws Exception {
        return dsi.updateDoctorDetails(doctor,password);
    }

}



