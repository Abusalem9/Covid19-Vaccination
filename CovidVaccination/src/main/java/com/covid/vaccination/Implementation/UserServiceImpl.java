package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.UserRepository;
import com.covid.vaccination.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
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
    public User updateUser(User user, String key) throws UserException {
        User user2 = new User();

        if (user2 == null) {
            throw new UserException("No user found. Please try login first.");
        }
       userRepository.save(user);
        return user;
    }
}
