package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Entity.DoctorDTO;
import com.covid.vaccination.Exception.DoctorException;
import com.covid.vaccination.Repository.DoctorRepository;
import com.covid.vaccination.Repository.DoctorSessionRepo;
import com.covid.vaccination.Service.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServicesImp implements DoctorServices {

    @Autowired
    private DoctorRepository doctorRepository;

    private DoctorSessionRepo dsRepo;

    private GetCurrentUserLoginSessionDetailsImpl getCurrentLoginDoctor;
    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctor(Integer did) throws DoctorException{
        return doctorRepository.findById(did).orElseThrow( ()-> {
            throw  new DoctorException("Can't found doctor with this id");
        });
    }

    @Override
    public void deleteDoctorById(Integer did) {
        doctorRepository.deleteById(did);
    }

    @Override
    public List<Doctor> getAllDoctors() throws DoctorException{

        List<Doctor> doctors= doctorRepository.findAll();
        if(doctors.size()<=0){
            throw new DoctorException("There is no any doctor present here.");
        }
        return doctors;
    }

    // Login Services Implementations
    @Override
    public String logIntoAccount(DoctorDTO DTO) {



    return "";
    }

    @Override
    public String logOutFromAccount(String key) {
        return null;
    }
}
