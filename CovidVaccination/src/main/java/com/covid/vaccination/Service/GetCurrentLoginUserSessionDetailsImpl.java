package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.CurrentUserSession;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.SessionRepository;
import com.covid.vaccination.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCurrentLoginUserSessionDetailsImpl implements GetCurrentLoginUserSessionDetailsInterface {
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CurrentUserSession getCurrentUserSession(String key) {
        Optional<CurrentUserSession> optional = sessionRepository.findByUuid(key);
        if (!optional.isPresent()) {
            throw new UserException("Unauthorized");
        }
        return optional.get();
    }

    @Override
    public Integer getCurrentUserSessionId(String key) {
        Optional<CurrentUserSession> optional = sessionRepository.findByUuid(key);
        if (!optional.isPresent()) {
            throw new UserException("Unauthorized");
        }
        return optional.get().getId();
    }

    public User getCurrentCustomer(String key) {
        Optional<CurrentUserSession> optional = sessionRepository.findByUuid(key);
        if (!optional.isPresent()) {
            throw new UserException("Unauthorized");
        }
        Integer userId = optional.get().getId();
        return userRepository.getReferenceById(userId);
    }
}
