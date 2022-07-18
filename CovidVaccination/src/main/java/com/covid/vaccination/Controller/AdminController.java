package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.*;
import com.covid.vaccination.Repository.UserRepository;
import com.covid.vaccination.Repository.VaccineStorageRepository;
import com.covid.vaccination.Service.*;
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

    //Get user by user id.

    @GetMapping("search/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return usi.getUserById(id);
    }
    //Get All Users from the database.
    @GetMapping("all/users")
    public List<User> getAllUserFromDB() {
        return usi.getAllUsers();
    }

    @GetMapping("all/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctorFromDB() {
        return doctorServicesImp.getAllDoctors();
    }
    @GetMapping("doctor/{dUserId}")
    public Doctor getDoctorFromDB(@PathVariable("dUserId") Integer dUserId) {
        return doctorServicesImp.getDoctor(dUserId);
    }


    @GetMapping("Dose1CompletedUsers")
    public List<Dose1> getAllDose1CompletedUsers(){
        return dose1Serviceimpl.getAllUser();
    }
    @GetMapping("BothDoseCompleted")
    public List<User> getAllDoseCompletedUsers(){
        return userRepository.getAllBothDoseCompleted();
    }
    @GetMapping("search/Aadhar/{AadharNo}")
    public User getUserByAadharNo(@PathVariable("AadharNo")String id){
        return userRepository.getUsersByAadharNo(id);
    }
    @GetMapping("search/Mobile/{Mobile}")
    public User getUserByMobileNo(@PathVariable("Mobile")String id){
        return userRepository.getUsersByMobileNo(id);
    }
    @PostMapping("create/user")
    public String createUser(@RequestBody User user){
        usi.saveUser(user);
        return "User Has Been Added Into DataBase.";
    }
    @PostMapping("create/doctor")
    public String createDoctor(@RequestBody Doctor doctor) {
        doctorServicesImp.addDoctor(doctor);
        return "Doctor Has Been Added Into DataBase.";
    }
    @PutMapping("update/user/")
    public User updateUserByUsingId(@RequestBody User user,@RequestParam String key){
        return usi.updateUser(user,key);
    }

    @DeleteMapping("delete/user/{id}")
    public User deleteUserByUserId(@PathVariable("id") Integer id){
        return usi.deleteUserById(id);
    }

    @DeleteMapping("delete/doctor/{id}")
    public ResponseEntity<Doctor> deleteDoctorUsingId(@PathVariable("id") Integer id) {

        return doctorServicesImp.deleteDoctorById(id);
    }
    @Autowired
    public VaccineStorageService vaccineStorageService;
    @PostMapping("/center/addVaccine")
    public VaccineStorage AddingVaccineToCenter(@RequestBody VaccineStorage vaccineStorage) {
        return vaccineStorageService.save(vaccineStorage);
    }
    @Autowired
    public centerAddressService centerCreationService;

    @PostMapping("/create/center")
    public ResponseEntity<centerAddress> createCenter(@RequestBody centerAddress centerAddress) {

        centerCreationService.saveCenterAddress(centerAddress);

        return new ResponseEntity<>(centerAddress, HttpStatus.OK);
    }

    @GetMapping("search/center/{id}")
    public ResponseEntity<centerAddress> getCenterById(@PathVariable("id")Integer id){
        centerAddress c= centerCreationService.getCenterAddressById(id);
        if(c!=null){
            return new ResponseEntity<>(c,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all/centers")
    public  ResponseEntity<List<centerAddress>> getAllAddress(){
        List<centerAddress> list = centerCreationService.getAllCenterList();
        if(list!=null){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("delete/center/{id}")
    public ResponseEntity<centerAddress> deleteCenterById(@PathVariable("id")Integer id){
        centerAddress c=centerCreationService.deleteCenterById(id);
        if(c!=null){
            return new ResponseEntity<>(c,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @PutMapping("update/center")
    public centerAddress updateCenter(@RequestBody centerAddress center) {
        centerCreationService.saveCenterAddress(center);
        return center;
    }

    @GetMapping ("search/centerStorage/{id}")
    public VaccineStorage getVaccineStorageByCenterId(@PathVariable("id") Integer id){
        return vaccineStorageRepository.findByCenterID(id);
    }
    @GetMapping("all/centerStorage")
    public List<VaccineStorage> getAllCenterVaccineStorage(){
        return vaccineStorageRepository.findAll();
    }
}
