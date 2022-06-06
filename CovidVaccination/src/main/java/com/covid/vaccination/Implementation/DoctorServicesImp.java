package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.DTO.DoctorDTO;
import com.covid.vaccination.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServicesImp implements DoctorServices{

    @Autowired
    public DoctorRepository doctorRepository;


    @Override
    public void addDoctor(Doctor doctor) {

    }

    @Override
    public Doctor getDoctor(Integer did) {
        return null;
    }

    @Override
    public void deleteDoctorById(Integer did) {

    }

    @Override
    public List<Doctor> getAllDoctors() {
        return null;
    }

    @Override
    public String loginAccount(DoctorDTO DTO) {
        return null;
    }

    @Override
    public String logoutAccount(String key) {
        return null;
    }

}
