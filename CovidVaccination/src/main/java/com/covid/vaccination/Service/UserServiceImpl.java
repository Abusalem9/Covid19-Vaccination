package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.UserRepository;
import com.covid.vaccination.util.GetCurrentLoginUserSessionDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository p;


    @Autowired
    private com.covid.vaccination.Repository.UserDao UserDao;

    @Autowired
    private GetCurrentLoginUserSessionDetailsImpl getCurrentLoginUser;

    @Override
    public void saveUser(User user) {
        p.save(user);
    }

    @Override
    @Query("select u from User as u")
    public User getUserById(Integer id) throws UserException {
        return p.findById(id).orElseThrow(() -> new UserException("User does not exist with Roll :" + id));
    }

    @Override

    public List<User> getAllUsers() throws UserException {
        return p.findAll();
    }

    @Override
    public User deleteUserById(Integer id) throws UserException {
        User existingUser= p.findById(id).orElseThrow( () -> new UserException("User does not exist with this Id :"+id) );
        p.delete(existingUser);
        return existingUser;
    }

    @Override
    public User updateUser(User user) throws UserException {
        Optional<User> opt= p.findById(user.getUser_id());
        if(opt.isPresent()) {
            User existingUser= opt.get();
            return p.save(user);
        }
        else
            throw new UserException("Invalid User Details..");
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
