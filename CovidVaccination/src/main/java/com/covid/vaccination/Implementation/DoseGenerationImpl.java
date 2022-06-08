package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.*;
import com.covid.vaccination.Exception.UserAlreadyExistWithMobileNumber;
import com.covid.vaccination.Repository.*;
import com.covid.vaccination.Service.DoseGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DoseGenerationImpl implements DoseGenerationService {
    @Autowired
    public DoseGenerationRepository doseGenerationRepository;
    @Autowired
    public Dose1Repository dose1Repository;
    @Autowired
    public Dose2Repository dose2Repository;

    @Autowired
    public  AppointmentServiceImpl appointmentService;
    @Autowired
    public AppointmentRepository appointmentRepository;
    @Autowired
    public DoctorServicesImp doctorServicesImp;
    @Autowired
    public DoctorRepository doctorRepository;
    
    public String generatedDose(DoctorDoseGeneration doctorDoseGeneration) {
        Doctor d=doctorRepository.getDoctorByDoctorId(doctorDoseGeneration.getDoctorId());
        if(d!=null){
            if(doctorDoseGeneration.getD_password().equals(d.getPassword())){
                Dose1 dose1 = dose1Repository.getDose1ByUser_id(doctorDoseGeneration.getUser_id());
                Dose2 dose2 = dose2Repository.getDose2ByUser_id(doctorDoseGeneration.getUser_id());
                Appointment appointment=appointmentRepository.findByUser_id(doctorDoseGeneration.getUser_id());

                if (dose1 == null && dose2 == null&&appointment!=null) {
                    doseGenerationRepository.save(doctorDoseGeneration);
                    appointmentRepository.delete(appointment);
                    return "Dose 1 SuccessFully Vaccinated";
                }

                else if ((dose1 != null) && dose2 == null) {
                    if(doctorDoseGeneration.getDose1()==null){
                        doseGenerationRepository.save(doctorDoseGeneration);
                        return "Dose 2 Successfully Vaccinated";
                    }else {
                        return "Already Dose 1 Completed";
                    }
                } else if(dose1!=null&&dose2!=null){
                    return "You Are Fully Vaccinated";
                }
                else
                    return "Please Book Your Slot";
            }
            else
                throw new UserAlreadyExistWithMobileNumber("Please Fill Correct Doctor Password");
        }
        else
            throw new UserAlreadyExistWithMobileNumber("Doctor Not Found/Exist");
        }
}
