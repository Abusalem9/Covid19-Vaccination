package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Entity.UserLogin;
import com.covid.vaccination.Exception.UserAlreadyExistWithMobileNumber;
import com.covid.vaccination.Repository.UserLoginRepository;
import com.covid.vaccination.Repository.UserRepository;
import com.covid.vaccination.Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class UserLoginServiceImpl implements UserLoginService {
   @Autowired
   public UserLoginRepository userLoginRepository;
   @Autowired
   public UserRepository userRepository;

    @Override
    public UserLogin login(UserLogin userLogin) {
        UserLogin userLoginByMobile=userLoginRepository.getUserLoginByMobile(userLogin.getMobile());
        if(userLoginByMobile==null){
            Optional<User> u=userRepository.findByMobile(userLogin.getMobile());
            if(u.isPresent()){
                User user= u.get();
                if(user.getPassword().equals(userLogin.getPassword())){
                    return userLoginRepository.save(userLogin);
                }
                else
                    throw new UserAlreadyExistWithMobileNumber("Please Check Your Password.");
            }
            else
                throw new UserAlreadyExistWithMobileNumber("User Not Found");
        }
        else
            throw new UserAlreadyExistWithMobileNumber("User Already Logged In.");

    }

    @Override
    public String logOut(UserLogin userLogin) {
        UserLogin u=userLoginRepository.getUserLoginByMobile(userLogin.getMobile());
        if (u!=null){
            if(u.getPassword().equals(userLogin.getPassword())){
                userLoginRepository.delete(u);
                return "User Has Been LogOut From The System.";
            }
            else
                throw new UserAlreadyExistWithMobileNumber("please fill your correct password");
        }
        else
            throw new UserAlreadyExistWithMobileNumber("Please Login First.");
    }
}
