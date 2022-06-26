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

    @Autowired
    public VaccineStorageRepository vaccineStorageRepository;

    @Autowired
    public VaccineStorageServiceImpl vaccineStorageService;

    @Autowired
    public DoctorLoginRepository doctorLoginRepository;
    
    public String generatedDose(DoctorDoseGeneration doctorDoseGeneration) {
        Doctor d=doctorRepository.getDoctorByDoctorId(doctorDoseGeneration.getDoctorId());
        DoctorLogin doctorLogin=doctorLoginRepository.getDoctorLoginByMobile(doctorRepository.getDoctorByDoctorId(doctorDoseGeneration.getDoctorId()).getMobile());
        if(doctorLogin!=null){
            if(d!=null){
                if(doctorDoseGeneration.getD_password().equals(d.getPassword())){
                    Appointment appointment=appointmentRepository.findByUser_id(doctorDoseGeneration.getUser_id());
                    Dose1 dose1 = dose1Repository.getDose1ByUser_id(doctorDoseGeneration.getUser_id());
                    Dose2 dose2 = dose2Repository.getDose2ByUser_id(doctorDoseGeneration.getUser_id());
                    if (dose1 == null && dose2 == null&&appointment!=null) {
                        doseGenerationRepository.save(doctorDoseGeneration);
                        vaccineStorageService.updateVaccineStorage(appointment.getCenter_id());
                        appointmentRepository.delete(appointment);
                        return "Dose 1 SuccessFully Vaccinated";
                    }
                    else if ((dose1 != null) && dose2 == null && appointment!=null) {
                        if(doctorDoseGeneration.getDose1()==null){
                            doseGenerationRepository.save(doctorDoseGeneration);
                            vaccineStorageService.updateVaccineStorage(appointment.getCenter_id());
                            appointmentRepository.delete(appointment);
                            return "Dose 2 Successfully Vaccinated";
                        }else {
                            return "Already Dose 1 Completed";
                        }
                    } else if(dose1!=null&&dose2!=null&&appointment==null){
                        return "You Are Fully Vaccinated";
                    }
                    else
                        return "Please Book Your Appointment";
                }
                else
                    throw new UserAlreadyExistWithMobileNumber("Please Fill Correct Doctor Password");
            }
            else
                throw new UserAlreadyExistWithMobileNumber("Doctor Not Found/Exist");
        }
        else
            throw new UserAlreadyExistWithMobileNumber("Please Login First.");
        }
}
