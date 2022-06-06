package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Entity.DoctorDTO;
import com.covid.vaccination.Entity.UserDTO;

import java.util.List;

public interface DoctorServices {

    void addDoctor(Doctor doctor);

     Doctor getDoctor(Integer did);

    void deleteDoctorById(Integer did);

    List<Doctor> getAllDoctors();


// Doctor  Login and logout services
    String logIntoAccount(DoctorDTO DTO);

    String logOutFromAccount(String key);



    // new functionalities

//    Doctor viewProfileIfLogedin( Integer did, String Sessionkey );



}
