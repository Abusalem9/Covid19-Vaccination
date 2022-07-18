package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Appointment;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Entity.UserLogin;
import com.covid.vaccination.Entity.centerAddress;
import com.covid.vaccination.Service.AppointmentService;
import com.covid.vaccination.Service.UserLoginService;
import com.covid.vaccination.Service.UserService;
import com.covid.vaccination.Service.centerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService usi;

    @Autowired
    public AppointmentService appointmentService;
//    Create User
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(usi.saveUser(user),HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public User updateUserByUsingId(@RequestBody User user,@RequestParam String password){
        return usi.updateUser(user,password);
    }

    @PostMapping("/book")
    public ResponseEntity<Appointment> setAppointmentOfDose(@RequestBody Appointment appointment){

        return appointmentService.setAppointment(appointment);
    }

    @Autowired
    public UserLoginService userLoginService;
    @PostMapping("Login")
    public UserLogin userLogin(@RequestBody UserLogin userLogin) {
        return userLoginService.login(userLogin);
    }

    @PostMapping("Logout")
    public String UserLogOut(@RequestBody UserLogin userLogin) {
        return userLoginService.logOut(userLogin);
    }
    @Autowired
    public centerAddressService centerCreationService;
    @GetMapping("GetAllCenter")
    public  ResponseEntity<List<centerAddress>> getAllAddress(){
        List<centerAddress> list = centerCreationService.getAllCenterList();
        if(list!=null){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
}
