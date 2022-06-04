package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.UserDTO;

public interface UserLogIn {

    String logIntoAccount(UserDTO userDTO);

    String logOutFromAccount(String key);
}
