package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    public  UserServiceImpl usi;
//    Create User
    @PostMapping("/createUser")
    public String createUser(@RequestBody User user){
        usi.saveUser(user);
        return "User Has Been Added Into DataBase.";
    }

//    get User Using User_id

// Update User Using Key.
    @PutMapping("/updateUser")
    public User updateUserByUsingId(@RequestBody User user,@RequestParam String key){
        return usi.updateUser(user,key);
    }
}
