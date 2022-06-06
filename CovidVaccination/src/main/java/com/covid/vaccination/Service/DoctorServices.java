package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.DTO.DoctorDTO;

import java.util.List;

public interface DoctorServices {

    void addDoctor(Doctor doctor);

     Doctor getDoctor(Integer did);

     //Doctors can't delete themselves.
//    void deleteDoctorById(Integer did);

    List<Doctor> getAllDoctors();


    Doctor updateDoctorDetails( String key, Doctor doctor);


// Doctor  Login and logout services
    String loginAccount(DoctorDTO DTO);

    String logoutAccount(String key);



    // new functionalities

//    Doctor viewProfileIfLogedin( Integer did, String Sessionkey );



}
