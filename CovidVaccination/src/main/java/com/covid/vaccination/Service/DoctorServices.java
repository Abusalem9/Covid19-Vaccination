package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Doctor;

import java.util.List;

public interface DoctorServices {

    void addDoctor(Doctor doctor);

     Doctor getDoctor(Integer did);

    void deleteDoctorById(Integer did);

    List<Doctor> getAllDoctors();

}
