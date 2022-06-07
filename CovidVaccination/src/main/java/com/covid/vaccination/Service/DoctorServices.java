package com.covid.vaccination.Service;

import com.covid.vaccination.DTO.DoctorDTO;
import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Exception.UserException;

import java.util.List;


public interface DoctorServices {

    Doctor addDoctor(Doctor doctor);

     Doctor getDoctor(Integer did);

    Doctor deleteDoctorById(Integer did);

    List<Doctor> getAllDoctors();


    Doctor updateDoctorDetails(String key, Doctor newdoctor) throws UserException;

    // Doctor  Login and logout services
    String loginAccount(DoctorDTO DTO);

    String logoutAccount(String key);


    // new functionalities

    Doctor viewProfile( String Sessionkey );



}
