package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.UserLogin;
import com.covid.vaccination.Implementation.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {
    @Autowired
    public UserLoginServiceImpl userLoginService;
    @PostMapping("/User/Login")
    public UserLogin userLogin(@RequestBody UserLogin userLogin) {
        return userLoginService.login(userLogin);
    }

    @PostMapping("/User/Logout")
    public String UserLogOut(@RequestBody UserLogin userLogin) {
        return userLoginService.logOut(userLogin);
    }
}
