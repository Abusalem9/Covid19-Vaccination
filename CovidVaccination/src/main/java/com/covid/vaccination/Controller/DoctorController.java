package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Appointment;
import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Entity.DoctorDoseGeneration;
import com.covid.vaccination.Entity.DoctorLogin;
import com.covid.vaccination.Service.AppointmentService;
import com.covid.vaccination.Service.DoctorLoginService;
import com.covid.vaccination.Service.DoctorServices;
import com.covid.vaccination.Service.DoseGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorServices dsi;
    @PostMapping("/addDoctor")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor){
        return dsi.addDoctor(doctor);
    }

    @Autowired
    public DoctorLoginService doctorLoginService;
    @PostMapping("Login")
    public DoctorLogin userLogin(@RequestBody DoctorLogin userLogin) {
        return doctorLoginService.login(userLogin);
    }

    @PostMapping("Logout")
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
    @Autowired
    public DoseGenerationService doseGenerationService;
    @Autowired
    public AppointmentService appointmentService;

    @PostMapping("Dose/CreateDose")
    public ResponseEntity<String> createDose(@RequestBody DoctorDoseGeneration doctorDoseGeneration){
        return  new ResponseEntity<>(doseGenerationService.generatedDose(doctorDoseGeneration), HttpStatus.CREATED);
    }
    @GetMapping("/getAllAppointment")
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        return appointmentService.getAllAppointment();
    }

}



