package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.CurrentUserSession;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.UserSessionRepository;
import com.covid.vaccination.Repository.UserRepository;
<<<<<<<< HEAD:CovidVaccination/src/main/java/com/covid/vaccination/Implementation/GetCurrentUserLoginSessionDetailsImpl.java
import com.covid.vaccination.Service.GetCurrentUserLoginSessionDetailsInterface;
========
import com.covid.vaccination.Service.GetCurrentLoginUserSessionDetailsInterface;
>>>>>>>> origin/main:CovidVaccination/src/main/java/com/covid/vaccination/Implementation/GetCurrentLoginUserSessionDetailsImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCurrentUserLoginSessionDetailsImpl implements GetCurrentUserLoginSessionDetailsInterface {
    @Autowired
    private UserSessionRepository userSessionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CurrentUserSession getCurrentUserSession(String key) {
        Optional<CurrentUserSession> optional = userSessionRepository.findByUuid(key);
        if (!optional.isPresent()) {
            throw new UserException("Unauthorized");
        }
        return optional.get();
    }

    @Override
    public Integer getCurrentUserSessionId(String key) {
        Optional<CurrentUserSession> optional = userSessionRepository.findByUuid(key);
        if (!optional.isPresent()) {
            throw new UserException("Unauthorized");
        }
        return optional.get().getId();
    }

    public User getCurrentCustomer(String key) {
        Optional<CurrentUserSession> optional = userSessionRepository.findByUuid(key);
        if (!optional.isPresent()) {
            throw new UserException("Unauthorized");
        }
        Integer userId = optional.get().getId();
        return userRepository.getReferenceById(userId);
    }
}
