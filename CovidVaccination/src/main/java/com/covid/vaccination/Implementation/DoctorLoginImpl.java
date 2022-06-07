package com.covid.vaccination.Implementation;

import com.covid.vaccination.DTO.DoctorDTO;
import com.covid.vaccination.Entity.CurrentDoctorSession;
import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Exception.InvalidMobileException;
import com.covid.vaccination.Exception.InvalidPasswordException;
import com.covid.vaccination.Exception.UserAlreadyExistWithMobileNumber;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.DoctorRepository;
import com.covid.vaccination.Repository.DoctorSessionRepository;
import com.covid.vaccination.Service.DoctorLogin;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DoctorLoginImpl implements DoctorLogin {


    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorSessionRepository doctorSessionRepository;

    @Autowired
    private GetCurrentDoctorLoginSessionImp getCurrentLoginDoctor;

    @Override
    public String logIntoAccount(DoctorDTO doctorDTO) {

        Optional<Doctor> opt = doctorRepository.findByMobile(doctorDTO.getMobile());


        if (doctorDTO.getMobile().length() != 10 || !opt.isPresent()) {
            throw new InvalidMobileException("Please Enter Valid Mobile No");
        }

        Doctor doctor = opt.get();

        Integer Id = doctor.getDoctorId();


        Optional<CurrentDoctorSession> currentDoctorOptional = doctorSessionRepository.findById(Id);


        if (!doctor.getPassword().equals(doctorDTO.getPassword())) {

            throw new InvalidPasswordException("Please Enter Valid Password");
        }
        if (currentDoctorOptional.isPresent()) {
            throw new UserAlreadyExistWithMobileNumber("User already logged in with this number");
        } else {


            String key = RandomString.make(6);

            CurrentDoctorSession currentDoctorSession = new CurrentDoctorSession(doctor.getDoctorId(), key, LocalDateTime.now());
            doctorSessionRepository.save(currentDoctorSession);

            return currentDoctorSession.toString();

        }

    }


    @Override
    public String logOutFromAccount(String key) {

        Optional<CurrentDoctorSession> currentDoctorOptional = doctorSessionRepository.findByUuid(key);

        if (!currentDoctorOptional.isPresent()) {
            throw new UserException("Doctor is not logged in with this number");
        }

        CurrentDoctorSession currentdoctorSession = getCurrentLoginDoctor.getCurrentDoctorSession(key);
        doctorSessionRepository.delete(currentdoctorSession);

        return "Logged Out...";
    }


}
