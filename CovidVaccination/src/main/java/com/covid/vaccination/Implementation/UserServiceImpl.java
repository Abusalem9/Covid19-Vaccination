package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Entity.UserLogin;
import com.covid.vaccination.Exception.UserAlreadyExistWithMobileNumber;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.UserLoginRepository;
import com.covid.vaccination.Repository.UserRepository;
import com.covid.vaccination.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public UserLoginRepository userLoginRepository;

    @Override
    public User saveUser(User user) {
        Optional<User> newUser=userRepository.findByMobile(user.getMobile());
        User aadhar=userRepository.getUsersByAadharNo(user.getAadharNo());
        if(newUser.isPresent()||aadhar!=null){
            throw new UserAlreadyExistWithMobileNumber("User Has Been Already Registered With This Mobile Number Or Aadhar Number.");
        }
        return userRepository.save(user);
    }

    @Override
    @Query("select u from User as u")
    public User getUserById(Integer id) throws UserException {
        return userRepository.findById(id).orElseThrow(() -> new UserException("User does not exist with Roll :" + id));
    }

    @Override

    public List<User> getAllUsers() throws UserException {
        return userRepository.findAll();
    }

    @Override
    public User deleteUserById(Integer id) throws UserException {

        User existingUser= userRepository.findById(id).orElseThrow( () -> new UserException("User does not exist with this Id :"+id) );
        userRepository.delete(existingUser);
        return existingUser;
    }

    @Override
    public User updateUser(User user, String password) throws UserException {
        Optional<User> user2 = userRepository.findById(user.getUser_id());
        if(user2.isPresent()){
            UserLogin u=userLoginRepository.getUserLoginByMobile(user2.get().getMobile());
            if(u!=null){
                if(u.getPassword().equals(password)){
                    User updated= userRepository.save(user);
                    userLoginRepository.delete(u);
                    return updated;
                }
                else
                    throw new UserAlreadyExistWithMobileNumber("Please fill Correct password");
            }
            else
                throw new UserAlreadyExistWithMobileNumber("Please Login First.");
        }
        else
            throw new UserAlreadyExistWithMobileNumber("Please Check User Id");
    }
}
