package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.UserRepository;
import com.covid.vaccination.util.GetCurrentLoginUserSessionDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository p;


    @Autowired
    private com.covid.vaccination.Repository.UserDao UserDao;

    @Autowired
    private GetCurrentLoginUserSessionDetailsImpl getCurrentLoginUser;

    @Override
    public User saveUser(User user) {
        return p.save(user);
    }

    @Override
    @Query("select u.firstName from User as u")
    public User getUserById(Integer id) throws UserException {
        return p.findById(id).orElseThrow(() -> new UserException("User does not exist with Roll :" + id));
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

    @Override
    public User updateUser(User user, String key) throws UserException {
        User user2 = getCurrentLoginUser.getCurrentCustomer(key);

        if (user2 == null) {
            throw new UserException("No user found.. try login first");
        }

        UserDao.save(user);
        return user;
    }
}
