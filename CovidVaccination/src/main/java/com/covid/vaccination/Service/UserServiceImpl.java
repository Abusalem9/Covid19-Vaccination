package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    public UserRepository p;

    @Override
    public User saveUser(User user) {
        return p.save(user);
    }

    @Override
    public User getUserById(Integer id) throws UserException {
        return p.findById(id).orElseThrow(() -> new UserException("User does not exist with Roll :"+id));
    }

    @Override
    public List<User> getAllUsers() throws UserException {
        return null;
    }

    @Override
    public User deleteUserByRId(Integer id) throws UserException {
        return null;
    }

    @Override
    public User updateUser(User user) throws UserException {
        return null;
    }
}
