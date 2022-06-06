package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.CurrentUserSession;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserException;

public interface GetCurrentUserLoginSessionDetailsInterface {
    public CurrentUserSession getCurrentUserSession(String key) throws UserException;
    Integer getCurrentUserSessionId(String key) throws UserException;
    User getCurrentCustomer(String key) throws UserException;

}
