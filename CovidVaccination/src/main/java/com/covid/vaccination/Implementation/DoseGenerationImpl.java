package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.DoctorDoseGeneration;
import com.covid.vaccination.Entity.Dose1;
import com.covid.vaccination.Repository.Dose1Repository;
import com.covid.vaccination.Repository.DoseGenerationRepository;
import com.covid.vaccination.Service.DoseGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseGenerationImpl implements DoseGenerationService {
    @Autowired
    public DoseGenerationRepository doseGenerationRepository;
    @Autowired
    public Dose1Repository dose1Repository;

    public String generatedDose(DoctorDoseGeneration doctorDoseGeneration) {

//        Dose1 d=dose1Repository.getDose1ByUser_id(doctorDoseGeneration.getUser_id());

        if(true){
            doseGenerationRepository.save(doctorDoseGeneration);
        }

       return "SuccessFully Dose Completed ";
    }
}
