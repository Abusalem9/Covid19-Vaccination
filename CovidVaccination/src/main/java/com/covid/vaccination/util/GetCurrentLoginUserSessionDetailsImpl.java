package com.covid.vaccination.util;

import com.covid.vaccination.Entity.CurrentUserSession;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.SessionDAO;
import com.covid.vaccination.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCurrentLoginUserSessionDetailsImpl implements GetCurrentLoginUserSessionDetailsInterface {

    @Autowired
    private SessionDAO sessionDAO;

    @Autowired
    private UserDao userDao;

    @Override
    public CurrentUserSession getCurrentUserSession(String key) {
        Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);

        if (!optional.isPresent()) {
            throw new UserException("Unauthorized");
        }

        return optional.get();
    }

    @Override
    public Integer getCurrentUserSessionId(String key) {
        Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);

        if (!optional.isPresent()) {
            throw new UserException("Unauthorized");
        }

        return optional.get().getId();
    }

    public User getCurrentCustomer(String key) {
        Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);

        if (!optional.isPresent()) {
            throw new UserException("Unauthorized");
        }

        Integer userId = optional.get().getId();

        return userDao.getReferenceById(userId);
    }
}
