package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.DoctorDoseGeneration;
import com.covid.vaccination.Entity.Dose1;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.DoseGenerationRepository;
import com.covid.vaccination.Service.DoseGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoseGenerationImpl implements DoseGenerationService {
    @Autowired
    public DoseGenerationRepository doseGenerationRepository;

    @Autowired
    public Dose1Impl dose1impl;
    @Override
    public String generatedDose(DoctorDoseGeneration doctorDoseGeneration) {

        Dose1 d=dose1impl.getUserById(doctorDoseGeneration.getUser_id());

        if(d.getUser_id()!=null){
            doseGenerationRepository.save(doctorDoseGeneration);
        }



       return "SuccessFully Dose Completed ";
    }
}
