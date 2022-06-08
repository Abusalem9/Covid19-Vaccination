package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Center;
import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Entity.Dose1;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Implementation.DoctorServicesImp;
import com.covid.vaccination.Implementation.Dose1ServiceImpl;
import com.covid.vaccination.Implementation.UserServiceImpl;
import com.covid.vaccination.Implementation.centerAllocationServiceImpl;
import com.covid.vaccination.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    public centerAllocationServiceImpl cImpl;
    @Autowired
    public UserServiceImpl usi;

    @Autowired
    public DoctorServicesImp doctorServicesImp;
    @Autowired
    public Dose1ServiceImpl dose1Serviceimpl;

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/Admin/User/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return usi.getUserById(id);
    }
//    Get All Users

    @GetMapping("/Admin/Users")
    public List<User> getAllUserFromDB(){
        return usi.getAllUsers();
    }
    @GetMapping("/Admin/Doctors/getAllDoctors")
    public List<Doctor> getAllDoctorFromDB() {
        return doctorServicesImp.getAllDoctors();
    }
    @GetMapping("/Admin/Doctor/{dUserId}")
    public Doctor getDoctorFromDB(@PathVariable("dUserId") Integer dUserId) {
        return doctorServicesImp.getDoctor(dUserId);
    }

    @GetMapping("/Admin/getCenter/{id}")
    public Center getCenterAddressById(@PathVariable("id") Integer id) {

        return cImpl.getCenterById(id);
    }

    @GetMapping("/Admin/getAllCenter/")
    public List<Center> getCenterAddressById() {

        return cImpl.getAllCenter();
    }
    @GetMapping("/Admin/getAllDose1CompletedUsers")
    public List<Dose1> getAllDose1CompletedUsers(){
        return dose1Serviceimpl.getAllUser();
    }
    @GetMapping("/Admin/GetUserByAadhar/{AadharNo}")
    public User getUserByAadharNo(@PathVariable("AadharNo")String id){
        return userRepository.getUsersByAadharNo(id);
    }
    @GetMapping("/Admin/GetUserByMobile/{Mobile}")
    public User getUserByMobileNo(@PathVariable("Mobile")String id){
        return userRepository.getUsersByMobileNo(id);
    }
    @PostMapping("/Admin/createUser")
    public String createUser(@RequestBody User user){
        usi.saveUser(user);
        return "User Has Been Added Into DataBase.";
    }
    @PostMapping("/Admin/createCenter")
    public Center createCenterAddress(@RequestBody Center center) {
        cImpl.saveCenter(center);
        return center;
    }
    @PostMapping("/Admin/createDoctor")
    public String createDoctor(@RequestBody Doctor doctor) {
        doctorServicesImp.addDoctor(doctor);
        return "Doctor Has Been Added Into DataBase.";
    }
    @PutMapping("/Admin/updateUser")
    public User updateUserByUsingId(@RequestBody User user,@RequestParam String key){
        return usi.updateUser(user,key);
    }
    @PutMapping("/Admin/updateDoctor")
    public Doctor updateDoctor(@RequestBody Doctor doctor) {

        return doctorServicesImp.updateDoctorDetails("1111",doctor);
    }
    @PutMapping("/Admin/updateCenter")
    public Center updateCenter(@RequestBody Center center) {
        cImpl.saveCenter(center);
        return center;
    }
    @DeleteMapping("/Admin/deleteUser/{id}")
    public User deleteUserByUserId(@PathVariable("id") Integer id){

        return usi.deleteUserById(id);
    }

    @DeleteMapping("/Admin/deleteCenter/{id}")
    public Center deleteCenterCenterId(@PathVariable("id") Integer id) {

        return cImpl.deleteCenterId(id);
    }

    @DeleteMapping("/Admin/deleteDoctor/{id}")
    public Doctor deleteDoctorUsingId(@PathVariable("id") Integer id) {
        return doctorServicesImp.deleteDoctorById(id);
    }
}
