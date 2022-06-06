package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.UserDTO;
import com.covid.vaccination.Implementation.UserLogInImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private UserLogInImpl userlog;

    // for user Login
    @PostMapping(value = "/login")
    public String logInCustomer(@RequestBody UserDTO userDTO) {
        return userlog.logIntoAccount(userDTO);
    }

    // for user Logout
    @PatchMapping(value = "/logout")
    public String logOutCustomer(@RequestParam String key) {
        return userlog.logOutFromAccount(key);
    }
}
