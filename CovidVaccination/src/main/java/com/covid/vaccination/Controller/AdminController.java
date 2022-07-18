package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.*;
import com.covid.vaccination.Implementation.*;
import com.covid.vaccination.Repository.UserRepository;
import com.covid.vaccination.Repository.VaccineStorageRepository;
import com.covid.vaccination.Service.DoctorServices;
import com.covid.vaccination.Service.Dose1Service;
import com.covid.vaccination.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    public UserService usi;

    @Autowired
    public DoctorServices doctorServicesImp;
    @Autowired
    public Dose1Service dose1Serviceimpl;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public VaccineStorageRepository vaccineStorageRepository;

    @GetMapping("User/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return usi.getUserById(id);
    }
//    Get All Users

    @GetMapping("Users")
    public List<User> getAllUserFromDB() {
        return usi.getAllUsers();
    }

    @GetMapping("Doctors/getAllDoctors")
    public ResponseEntity<List<Doctor>> getAllDoctorFromDB() {
        return doctorServicesImp.getAllDoctors();
    }
    @GetMapping("Doctor/{dUserId}")
    public Doctor getDoctorFromDB(@PathVariable("dUserId") Integer dUserId) {
        return doctorServicesImp.getDoctor(dUserId);
    }


    @GetMapping("getAllDose1CompletedUsers")
    public List<Dose1> getAllDose1CompletedUsers(){
        return dose1Serviceimpl.getAllUser();
    }
    @GetMapping("BothDoseDone")
    public List<User> getAllDoseCompletedUsers(){
        return userRepository.getAllBothDoseCompleted();
    }
    @GetMapping("GetUserByAadhar/{AadharNo}")
    public User getUserByAadharNo(@PathVariable("AadharNo")String id){
        return userRepository.getUsersByAadharNo(id);
    }
    @GetMapping("GetUserByMobile/{Mobile}")
    public User getUserByMobileNo(@PathVariable("Mobile")String id){
        return userRepository.getUsersByMobileNo(id);
    }
    @PostMapping("createUser")
    public String createUser(@RequestBody User user){
        usi.saveUser(user);
        return "User Has Been Added Into DataBase.";
    }
    @PostMapping("createDoctor")
    public String createDoctor(@RequestBody Doctor doctor) {
        doctorServicesImp.addDoctor(doctor);
        return "Doctor Has Been Added Into DataBase.";
    }
    @PutMapping("updateUser")
    public User updateUserByUsingId(@RequestBody User user,@RequestParam String key){
        return usi.updateUser(user,key);
    }
//    @PutMapping("updateDoctor")
//    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
//
//        return doctorServicesImp.updateDoctorDetails("1111",doctor);
//    }

    @DeleteMapping("deleteUser/{id}")
    public User deleteUserByUserId(@PathVariable("id") Integer id){
        return usi.deleteUserById(id);
    }

    @DeleteMapping("deleteDoctor/{id}")
    public ResponseEntity<Doctor> deleteDoctorUsingId(@PathVariable("id") Integer id) {

        return doctorServicesImp.deleteDoctorById(id);
    }
    @Autowired
    public VaccineStorageServiceImpl vaccineStorageService;
    @PostMapping("AddingVaccineToCenter")
    public VaccineStorage AddingVaccineToCenter(@RequestBody VaccineStorage vaccineStorage) {
        return vaccineStorageService.save(vaccineStorage);
    }
    @Autowired
    public CenterCreationServiceImpl centerCreationService;


    @PostMapping("/createCenter")
    public ResponseEntity<centerAddress> createCenter(@RequestBody centerAddress centerAddress) {

        centerCreationService.saveCenterAddress(centerAddress);

        return new ResponseEntity<>(centerAddress, HttpStatus.OK);
    }

    @GetMapping("GetCenter/{id}")
    public ResponseEntity<centerAddress> getCenterById(@PathVariable("id")Integer id){
        centerAddress c= centerCreationService.getCenterAddressById(id);
        if(c!=null){
            return new ResponseEntity<>(c,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("GetAllCenter")
    public  ResponseEntity<List<centerAddress>> getAllAddress(){
        List<centerAddress> list = centerCreationService.getAllCenterList();
        if(list!=null){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("Delete/{id}")
    public ResponseEntity<centerAddress> deleteCenterById(@PathVariable("id")Integer id){
        centerAddress c=centerCreationService.deleteCenterById(id);
        if(c!=null){
            return new ResponseEntity<>(c,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @PutMapping("updateCenter")
    public centerAddress updateCenter(@RequestBody centerAddress center) {
        centerCreationService.saveCenterAddress(center);
        return center;
    }

    @GetMapping ("GetStorageCenterById")
    public VaccineStorage getVaccineStorageByCenterId(@RequestParam Integer id){
        return vaccineStorageRepository.findByCenterID(id);
    }
    @GetMapping("GetAllCenterStorage")
    public List<VaccineStorage> getAllCenterVaccineStorage(){
        return vaccineStorageRepository.findAll();
    }
}
