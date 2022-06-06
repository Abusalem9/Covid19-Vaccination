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


// Doctor  Login and logout services
    String loginAccount(DoctorDTO DTO);

    String logoutAccount(String key);

    Doctor updateDoctor(Doctor doctor) throws UserException;

    // new functionalities

//    Doctor viewProfileIfLogedin( Integer did, String Sessionkey );



}
