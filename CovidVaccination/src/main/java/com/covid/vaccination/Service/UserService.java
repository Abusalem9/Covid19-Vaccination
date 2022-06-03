package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserException;
import java.util.List;

public interface UserService {
    public User saveUser(User user);

    public User getUserById(Integer id) throws UserException;

    public List<User> getAllUsers()throws UserException;

    public User deleteUserByRId(Integer id)throws UserException;

    public User updateUser(User user)throws UserException;
}
