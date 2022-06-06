package com.covid.vaccination.Implementation;
import com.covid.vaccination.Entity.CurrentDoctorSession;
import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.DTO.DoctorDTO;
import com.covid.vaccination.Exception.DoctorException;
import com.covid.vaccination.Exception.InvalidMobileException;
import com.covid.vaccination.Repository.DoctorRepository;
import com.covid.vaccination.Repository.DoctorSessionRepository;
import com.covid.vaccination.Service.DoctorServices;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServicesImp implements DoctorServices {

    @Autowired
    private DoctorRepository doctorRepository;
    private DoctorSessionRepository doctorSessionRepo;

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctor(Integer did) {
       Optional<Doctor> doctorOpt = doctorRepository.findById(did);
       if(!doctorOpt.isPresent()){
           throw new DoctorException("There is no any doctor with this ID");
       }
       return doctorOpt.get();
    }


// removing data deletion of doctors.
//    @Override
//    public void deleteDoctorById(Integer did) {
//
//    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        if(doctors.size()<=0)
            throw new DoctorException("There is no any doctor present in Database");

        return doctors;

    }

    @Override
    public Doctor updateDoctorDetails(String key, Doctor doctor) {

      Optional<CurrentDoctorSession> session = doctorSessionRepo.findByUuid(key);

      if(!session.isPresent())
          throw new DoctorException("you are not validated to update details..");

      Integer did =session.get().getId();

      return doctorRepository.save(doctor);

    }



    // Login and Logout Functionalities.. 
    // (To take charge of a particular center)
    @Override
    public String loginAccount(DoctorDTO dto) {
        
        Optional<Doctor> doctorOpt= doctorRepository.findByMobile(dto.getMobile());

        if (dto.getMobile().length() != 10 || !doctorOpt.isPresent()) {
            throw new InvalidMobileException("Please Enter Valid Mobile No");
        }
        
        Doctor currDoctor = doctorOpt.get();
        Integer did= currDoctor.getDoctorId();

        if(!currDoctor.getPassword().equals(dto.getPassword())){
            throw new DoctorException("Please enter a valid password");
        }
        
        Optional<CurrentDoctorSession> currentDoctorSession = doctorSessionRepo.findById(did);
        
        if(currentDoctorSession.isPresent()){
            throw new DoctorException("You are already working to a center..");
        }

        String key = RandomString.make(7);

        CurrentDoctorSession session = new CurrentDoctorSession(currDoctor.getDoctorId(),key, LocalDateTime.now());
        
        doctorSessionRepo.save(session);

        return doctorSessionRepo.toString();

    }

    @Override
    public String logoutAccount(String key) {

        Optional <CurrentDoctorSession> session = doctorSessionRepo.findByUuid(key);

        if (!session.isPresent()){
            throw new DoctorException("Invalid key OR Doctor is present in the center");
        }
        doctorSessionRepo.delete(session.get());

        return "Doctor is leaving from the center..";
    }
    
}
