package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.CurrentDoctorSession;
import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Exception.DoctorException;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.DoctorRepository;
import com.covid.vaccination.Repository.DoctorSessionRepo;
import com.covid.vaccination.Service.GetCurrentDoctorLoginSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Optional;

@Service
public class GetCurrentDoctorLoginSessionImp implements GetCurrentDoctorLoginSession {

    @Autowired
    private DoctorSessionRepo doctorSessionRepo;

    @Autowired
    private DoctorRepository doctorRepository;


    @Override
    public CurrentDoctorSession getCurrentDoctorSession(String key) throws UserException {
        Optional<CurrentDoctorSession> optional = doctorSessionRepo.findByUuid(key);
        if (!optional.isPresent()) {
            throw new UserException("You are not an Unauthorized to access this");
        }
        return optional.get();
    }

    @Override
    public Integer getCurrentDoctorSessionId(String key) throws UserException {

        Optional<CurrentDoctorSession> optional = doctorSessionRepo.findByUuid(key);
        if(!optional.isPresent()) throw new DoctorException("you are not Logged In");
        return optional.get().getId();
    }

    @Override
    public Doctor getCurrentDoctor(String key) throws UserException {
        Optional<CurrentDoctorSession> optional = doctorSessionRepo.findByUuid(key);
        if(!optional.isPresent()) throw new DoctorException("you are not Logged In");

        Integer id = optional.get().getId();
        return doctorRepository.getReferenceById(id);
    }

}
