package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.CurrentUserSession;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Repository.SessionRepository;
import com.covid.vaccination.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GetCurrentLoginUserSessionDetails {
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository;

    public CurrentUserSession getCurrentUserSession(String key) {
        Optional<CurrentUserSession> optional = sessionRepository.findByUuid(key);
        return optional.get();
    }

    public Integer getCurrentUserSessionId(String key) {
        Optional<CurrentUserSession> optional = sessionRepository.findByUuid(key);
        return optional.get().getId();
    }

    public User getCurrentCustomer(String key) {
        Optional<CurrentUserSession> optional = sessionRepository.findByUuid(key);
        Integer Id = optional.get().getId();
        return userRepository.getReferenceById(Id);
    }
}
