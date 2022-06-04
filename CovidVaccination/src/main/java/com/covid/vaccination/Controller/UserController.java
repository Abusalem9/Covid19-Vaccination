package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    public UserServiceImpl usi;


    @GetMapping("/User/{id}")
    public User getUserById(@PathVariable("id") Integer id) {

        return usi.getUserById(id);

    }
    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        usi.saveUser(user);
        return user;
    }


}
