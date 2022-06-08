package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Appointment;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Implementation.AppointmentServiceImpl;
import com.covid.vaccination.Implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    public  UserServiceImpl usi;

    @Autowired
    public AppointmentServiceImpl appointmentService;
//    Create User
    @PostMapping("/createUser")
    public String createUser(@RequestBody User user){
        usi.saveUser(user);
        return "User Has Been Added Into DataBase.";
    }

    @PutMapping("/updateUser")
    public User updateUserByUsingId(@RequestBody User user,@RequestParam String key){
        return usi.updateUser(user,key);
    }

    @PostMapping("/book/slot")
    public ResponseEntity<Appointment> setAppointmentOfDose(@RequestBody Appointment appointment){

        return appointmentService.setAppointment(appointment);
    }

}
