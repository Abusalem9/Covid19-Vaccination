package com.covid.vaccination.util;

import com.covid.vaccination.Entity.CurrentUserSession;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Repository.SessionDAO;
import com.covid.vaccination.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GetCurrentLoginUserSessionDetails {


    @Autowired
    private SessionDAO sessionDAO;

    @Autowired
    private UserDao userDao;

    public CurrentUserSession getCurrentUserSession(String key) {
        Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);

        return optional.get();
    }

    public Integer getCurrentUserSessionId(String key) {
        Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);

        return optional.get().getId();
    }

    public User getCurrentCustomer(String key) {
        Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);

        Integer Id = optional.get().getId();


        return userDao.getReferenceById(Id);
    }

//    public Wallet getCurrentUserWallet(String key) {
//        Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);
//
//        Integer Id = optional.get().getId();
//        User user = userDao.getById(Id);
//
//        Wallet wallet = customer.getWallet();
//
//        return wallet;
//    }

//    public Bank getCurrentUserBank(String key) {
//        Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);
//
//        Integer customerId = optional.get().getCustomerId();
//        Customer customer = customerDAO.getById(customerId);
//
//        Bank bank = customer.getWallet().getBank();
//
//        return bank;
//    }
}
