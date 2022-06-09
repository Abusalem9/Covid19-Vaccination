package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Doctor;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface DoctorServices {

    ResponseEntity<Doctor> addDoctor(Doctor doctor);

    Doctor getDoctor(Integer did);

    ResponseEntity<Doctor> deleteDoctorById(Integer did);

    ResponseEntity<List<Doctor>> getAllDoctors();

    ResponseEntity<Doctor> updateDoctorDetails(Doctor doctor,String password) throws Exception;


    ResponseEntity<Doctor> viewProfile( String Sessionkey );



}
