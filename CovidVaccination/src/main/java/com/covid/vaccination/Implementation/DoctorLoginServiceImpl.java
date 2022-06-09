package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Entity.DoctorLogin;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Entity.UserLogin;
import com.covid.vaccination.Exception.UserAlreadyExistWithMobileNumber;
import com.covid.vaccination.Repository.DoctorLoginRepository;
import com.covid.vaccination.Repository.DoctorRepository;
import com.covid.vaccination.Service.DoctorLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DoctorLoginServiceImpl implements DoctorLoginService {
    @Autowired
    public DoctorLoginRepository doctorLoginRepository;
    @Autowired
    public DoctorRepository doctorRepository;
    @Override
    public DoctorLogin login(DoctorLogin doctorLogin) {
        DoctorLogin doctorLoginByMobile=doctorLoginRepository.getDoctorLoginByMobile(doctorLogin.getMobile());
        if(doctorLoginByMobile==null){
            Optional<Doctor> u=doctorRepository.findByMobile(doctorLogin.getMobile());
            if(u.isPresent()){
                Doctor user= u.get();
                if(user.getPassword().equals(doctorLogin.getPassword())){
                    return doctorLoginRepository.save(doctorLogin);
                }
                else
                    throw new UserAlreadyExistWithMobileNumber("Please Check Your Password.");
            }
            else
                throw new UserAlreadyExistWithMobileNumber("Doctor Not Found");
        }
        else
            throw new UserAlreadyExistWithMobileNumber("Doctor Already Logged In.");
    }

    @Override
    public String logOut(DoctorLogin doctorLogin) {
        DoctorLogin u=doctorLoginRepository.getDoctorLoginByMobile(doctorLogin.getMobile());
        if (u!=null){
            if(u.getPassword().equals(doctorLogin.getPassword())){
                doctorLoginRepository.delete(u);
                return "Doctor Has Been Successfully Logged Out.";
            }
            else
                throw new UserAlreadyExistWithMobileNumber("please fill your correct password");
        }
        else
            throw new UserAlreadyExistWithMobileNumber("Please Login First.");
    }
}
