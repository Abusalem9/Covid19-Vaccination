package com.covid.vaccination.Contider;

import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Repository.UserRepository;
import com.covid.vaccination.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    public UserServiceImpl usi;
    @Autowired
    public UserRepository p;
    @GetMapping("/User/{id}")
    public User getUserById(@PathVariable("id") Integer id) {

        return usi.getUserById(id);

    }
    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        usi.saveUser(user);
        return user;
    }
//    @GetMapping("/uss")
//    public List<String> getUser(@PathVariable String name){
//       return p.getFirstNameAndLastNameFromUser();
//    }
    @GetMapping("/url")
    public Optional<User> getallfromme(){
        return p.findById(1);
    }
}
