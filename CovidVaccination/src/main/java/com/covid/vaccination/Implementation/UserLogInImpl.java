package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.CurrentUserSession;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.DTO.UserDTO;
import com.covid.vaccination.Exception.InvalidMobileException;
import com.covid.vaccination.Exception.InvalidPasswordException;
import com.covid.vaccination.Exception.UserAlreadyExistWithMobileNumber;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.UserSessionRepository;
import com.covid.vaccination.Repository.UserRepository;
import com.covid.vaccination.Service.UserLogIn;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class UserLogInImpl implements UserLogIn {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSessionRepository userSessionRepository;

    @Autowired
    private GetCurrentUserLoginSessionDetailsImpl getCurrentLoginUser;

    @Override
    public String logIntoAccount(UserDTO userDTO) {

        Optional<User> opt = userRepository.findByMobile(userDTO.getMobile());


        if (userDTO.getMobile().length() != 10 || !opt.isPresent()) {
            throw new InvalidMobileException("Please Enter Valid Mobile No");
        }

        User user = opt.get();

       Integer Id = user.getUser_id();


        Optional<CurrentUserSession> currentUserOptional = userSessionRepository.findById(Id);


        if (!user.getPassword().equals(userDTO.getPassword())) {

            throw new InvalidPasswordException("Please Enter Valid Password");
        }
        if (currentUserOptional.isPresent()) {
            throw new UserAlreadyExistWithMobileNumber("User already logged in with this number");
        } else {


            String key = RandomString.make(6);

            CurrentUserSession currentUserSession = new CurrentUserSession(user.getUser_id(), key, LocalDateTime.now());
            userSessionRepository.save(currentUserSession);

            return currentUserSession.toString();

        }

    }

    @Override
    public String logOutFromAccount(String key) {

        Optional<CurrentUserSession> currentUserOptional = userSessionRepository.findByUuid(key);

        if (!currentUserOptional.isPresent()) {
            throw new UserException("User is not logged in with this number");
        }

        CurrentUserSession currentUserSession = getCurrentLoginUser.getCurrentUserSession(key);
        userSessionRepository.delete(currentUserSession);

        return "Logged Out...";
    }
}
