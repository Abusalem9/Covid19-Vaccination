package com.covid.vaccination.Service;

import com.covid.vaccination.DTO.DoctorDTO;
import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Exception.UserException;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface DoctorServices {

    ResponseEntity<Doctor> addDoctor(Doctor doctor);

    ResponseEntity<Doctor> getDoctor(Integer did);

    ResponseEntity<Doctor> deleteDoctorById(Integer did);

    ResponseEntity<List<Doctor>> getAllDoctors();


    ResponseEntity<Doctor> updateDoctorDetails(String key, Doctor newdoctor) throws Exception;

    // Doctor  Login and logout services
    String loginAccount(DoctorDTO DTO);

    String logoutAccount(String key);


    // new functionalities

    Doctor viewProfile( String Sessionkey );



}
