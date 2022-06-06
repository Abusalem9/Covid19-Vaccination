package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.CurrentDoctorSession;
import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Exception.UserException;

public interface GetCurrentDoctorLoginSession {

    public CurrentDoctorSession getCurrentDoctorSession(String key) throws UserException;

    Integer getCurrentDoctorSessionId(String key) throws UserException;

    Doctor getCurrentDoctor(String key) throws UserException;

}
