package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.UserLogin;

public interface UserLoginService {
    public UserLogin login(UserLogin userLogin);
    public String logOut(UserLogin userLogin);
}
