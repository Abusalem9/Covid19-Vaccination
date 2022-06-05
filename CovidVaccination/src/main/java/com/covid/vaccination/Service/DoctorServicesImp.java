package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Exception.DoctorException;
import com.covid.vaccination.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DoctorServicesImp implements DoctorServices{

    @Autowired
    public DoctorRepository doctorRepository;

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctor(Integer did) throws DoctorException{
      Doctor doctor= doctorRepository.findById(did).orElseThrow( ()-> {
         throw  new DoctorException("Can't found doctor with this ID");
      });
      return doctor;
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
}
