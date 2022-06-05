package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    public UserServiceImpl usi;

//    Create User
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        usi.saveUser(user);
        return user;
    }

//    get User Using User_id
    @GetMapping("/User/{id}")
    public User getUserById(@PathVariable("id") Integer id) {

        return usi.getUserById(id);

    }
//    Get All Users

    @GetMapping("/Users")
    public List<User> getAllUserFromDB(){
        return usi.getAllUsers();
    }
// Delete User By Id
    @DeleteMapping("/deleteUser/{id}")
    public User deleteUserUsingId(@PathVariable("id") Integer id){
        return usi.deleteUserById(id);
    }
// Update User Using Key.
    @PutMapping("/updateUser")
    public User updateUserByUsingId(@RequestBody User user,@RequestParam String key){
        return usi.updateUser(user,key);
    }
}
