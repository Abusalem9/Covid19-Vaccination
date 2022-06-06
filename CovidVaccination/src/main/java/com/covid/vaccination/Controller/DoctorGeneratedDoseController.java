package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.DoctorDoseGeneration;
import com.covid.vaccination.Implementation.DoseGenerationImpl;
import com.covid.vaccination.Service.DoseGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorGeneratedDoseController {
    @Autowired
    public DoseGenerationImpl doseGenerationService;


    @PostMapping("/Doctor/Dose/CreateDose")
    public String createDose(@RequestBody DoctorDoseGeneration doctorDoseGeneration){
        return   doseGenerationService.generatedDose(doctorDoseGeneration);

    }
}
