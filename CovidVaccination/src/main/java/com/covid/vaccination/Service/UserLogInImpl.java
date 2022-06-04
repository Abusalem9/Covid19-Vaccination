package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.CurrentUserSession;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Entity.UserDTO;
import com.covid.vaccination.Exception.InvalidPasswordException;
import com.covid.vaccination.Exception.UserAlreadyExistWithMobileNumber;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.SessionDAO;
import com.covid.vaccination.Repository.UserDao;
import com.covid.vaccination.util.GetCurrentLoginUserSessionDetailsImpl;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class UserLogInImpl implements UserLogIn {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SessionDAO sessionDAO;

    @Autowired
    private GetCurrentLoginUserSessionDetailsImpl getCurrentLoginUser;

    @Override
    public String logIntoAccount(UserDTO userDTO) {
        Optional<User> opt = userDao.findByMobile(userDTO.getMobileNo());
        User user = opt.get();

        Integer Id = user.getId();

        Optional<CurrentUserSession> currentUserOptional = sessionDAO.findById(Id);

        if (!opt.isPresent()) {
            throw new UserException("Please Enter Valid Mobile Number");
        }

        if (currentUserOptional.isPresent()) {
            throw new UserAlreadyExistWithMobileNumber("User already logged in with this number");
        }

        if (user.getPassword().equals(userDTO.getPassword())) {

            String key = RandomString.make(6);

            CurrentUserSession currentUserSession = new CurrentUserSession(user.getId(), key, LocalDateTime.now());
            sessionDAO.save(currentUserSession);

            return currentUserSession.toString();
        } else {
            throw new InvalidPasswordException("Please Enter Valid Password");
        }
    }

    @Override
    public String logOutFromAccount(String key) {

        Optional<CurrentUserSession> currentUserOptional = sessionDAO.findByUuid(key);

        if (!currentUserOptional.isPresent()) {
            throw new UserException("User is not logged in with this number");
        }

        CurrentUserSession currentUserSession = getCurrentLoginUser.getCurrentUserSession(key);
        sessionDAO.delete(currentUserSession);

        return "Logged Out...";
    }
}
