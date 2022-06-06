package com.covid.vaccination.Implementation;

import com.covid.vaccination.DTO.DoctorDTO;
import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.DoctorRepository;
import com.covid.vaccination.Service.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServicesImp implements DoctorServices {

    @Autowired
    public DoctorRepository doctorRepo;

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @Override
    public Doctor getDoctor(Integer did) {
        return null;
    }

    @Override
    public Doctor deleteDoctorById(Integer did) {

        Doctor existingDoctor = doctorRepo.findById(did).orElseThrow(() -> new UserException("Doctor does not exist with this Id :" + did));
        doctorRepo.delete(existingDoctor);
        return existingDoctor;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    @Override
    public String loginAccount(DoctorDTO DTO) {
        return null;
    }

    @Override
    public String logoutAccount(String key) {
        return null;
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) throws UserException {
        Doctor doctor2 = getDoctor(doctor.getDoctorId());

        if (doctor2 == null) {
            throw new UserException("No user found. Please try login first.");
        }
        doctorRepo.save(doctor);
        return doctor;
    }
}
