package com.covid.vaccination.util;

import com.covid.vaccination.Entity.CurrentUserSession;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserException;

public interface GetCurrentLoginUserSessionDetailsInterface {

    CurrentUserSession getCurrentUserSession(String key) throws UserException;

    Integer getCurrentUserSessionId(String key) throws UserException;

    User getCurrentCustomer(String key) throws UserException;
//
//    public Wallet getCurrentUserWallet(String key) throws NotFoundException;
//
//    public Bank getCurrentUserBank(String key) throws NotFoundException;
}
