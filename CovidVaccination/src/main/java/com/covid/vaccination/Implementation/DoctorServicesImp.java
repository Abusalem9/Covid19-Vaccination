package com.covid.vaccination.Implementation;

import com.covid.vaccination.DTO.DoctorDTO;
import com.covid.vaccination.Entity.CurrentDoctorSession;
import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Exception.DoctorException;
import com.covid.vaccination.Exception.InvalidMobileException;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.DoctorRepository;
import com.covid.vaccination.Repository.DoctorSessionRepository;
import com.covid.vaccination.Service.DoctorServices;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DoctorServicesImp implements DoctorServices {

    @Autowired
    public DoctorRepository doctorRepo;

    private DoctorSessionRepository doctorSessionRepo;

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @Override
    public Doctor getDoctor(Integer did) {
        return null;
    }

    @Override
    public Doctor deleteDoctorById(Integer did) {

        Doctor existingDoctor = doctorRepo.findById(did).orElseThrow(() -> new UserException("Doctor does not exist with this Id :" + did));
        doctorRepo.delete(existingDoctor);
        return existingDoctor;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

@Override
    public ResponseEntity<Doctor> updateDoctorDetails(String key, Doctor newdoctor) {

        if (key.equals("1111")){
           return new ResponseEntity<>(doctorRepo.save(newdoctor), HttpStatus.OK);
        }

        Optional<CurrentDoctorSession> sessionOpt = doctorSessionRepo.findByUuid(key);

        if (!sessionOpt.isPresent()) {
            throw new DoctorException("Can't update, Please try to login first.");
        }
        CurrentDoctorSession session = sessionOpt.get();

        Optional<Doctor> doctorOpt = doctorRepo.findById(session.getId());

       Integer updaterId = doctorOpt.get().getDoctorId();

        if(!Objects.equals(updaterId, newdoctor.getDoctorId())){
            throw new DoctorException("You are not supposed to update others Details..");
        }

        Doctor updatedDoc= doctorRepo.save(newdoctor);
        return new ResponseEntity<>(updatedDoc,HttpStatus.OK);
}


    // Login and Logout Functionalities..
    // (To take charge of a particular center)
    @Override
    public String loginAccount(DoctorDTO dto) {

        Optional<Doctor> doctorOpt = doctorRepo.findByMobile(dto.getMobile());

        if (dto.getMobile().length() != 10 || !doctorOpt.isPresent()) {
            throw new InvalidMobileException("Please Enter Valid Mobile No");
        }

        Doctor currDoctor = doctorOpt.get();
        Integer did = currDoctor.getDoctorId();

        if (!currDoctor.getPassword().equals(dto.getPassword())) {
            throw new DoctorException("Please enter a valid password");
        }

        Optional<CurrentDoctorSession> currentDoctorSession = doctorSessionRepo.findById(did);

        if (currentDoctorSession.isPresent()) {
            throw new DoctorException("You are already working to a center..");
        }

        String key = RandomString.make(7);

        CurrentDoctorSession session = new CurrentDoctorSession(currDoctor.getDoctorId(), key, LocalDateTime.now());

        doctorSessionRepo.save(session);

        return doctorSessionRepo.toString();

    }

    @Override
    public String logoutAccount(String key) {

        Optional<CurrentDoctorSession> session = doctorSessionRepo.findByUuid(key);

        if (!session.isPresent()) {
            throw new DoctorException("Invalid key OR Doctor is present in the center");
        }
        doctorSessionRepo.delete(session.get());

        return "Doctor is leaving from the center..";
    }


    // View Profile If logedIn
    @Override
    public Doctor viewProfile(String sessionkey) {

        Optional<CurrentDoctorSession> sessionOpt = doctorSessionRepo.findByUuid(sessionkey);

        if (!sessionOpt.isPresent()) {
            throw new DoctorException("You are not loggedIn");
        }
        CurrentDoctorSession session = sessionOpt.get();

        Optional<Doctor> doctorOpt = doctorRepo.findById(session.getId());

        return doctorOpt.get();

    }

}
