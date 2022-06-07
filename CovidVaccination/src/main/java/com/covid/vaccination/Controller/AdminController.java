package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Address;
import com.covid.vaccination.Entity.Center;
import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Implementation.AddressServiceImpl;
import com.covid.vaccination.Implementation.DoctorServicesImp;
import com.covid.vaccination.Implementation.UserServiceImpl;
import com.covid.vaccination.Implementation.centerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    public centerServiceImpl cImpl;
    @Autowired
    public UserServiceImpl usi;

    @Autowired
    public DoctorServicesImp doctorServicesImp;
    @Autowired
    public AddressServiceImpl addressService;

    @GetMapping("/Admin/User/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return usi.getUserById(id);
    }
//    Get All Users

    @GetMapping("/Admin/Users")
    public List<User> getAllUserFromDB(){
        return usi.getAllUsers();
    }
    // Delete User By Id
    @DeleteMapping("/Admin/deleteUser/{id}")
    public User deleteUserUsingId(@PathVariable("id") Integer id){

        return usi.deleteUserById(id);
    }
    @PostMapping("/Admin/createUser")
    public String createUser(@RequestBody User user){
        usi.saveUser(user);
        return "User Has Been Added Into DataBase.";
    }

//    get User Using User_id

    // Update User Using Key.
    @PutMapping("/Admin/updateUser")
    public User updateUserByUsingId(@RequestBody User user,@RequestParam String key){
        return usi.updateUser(user,key);
    }

    @PostMapping("/Admin/Address/createAddress")
    public Address createAddress(@Valid @RequestBody Address address){
        addressService.saveAddress(address);
        return address;
    }

    //    get Address Using Address_id
    @GetMapping("/Admin/Address/{id}")
    public Address getAddressById(@Valid @PathVariable("id") Integer id) {

        return addressService.getAddressById(id);

    }
//    Get All Addresss

    // Delete Address By Id
    @DeleteMapping("/Admin/Address/deleteAddress/{id}")
    public Address deleteAddressUsingId(@Valid @PathVariable("id") Integer id) {
        return addressService.deleteAddressById(id);
    }

    // Update Address Using KeyaddressService.
    @PutMapping("/Admin/Address/updateAddress")
    public Address updateAddressByUsingId(@Valid @RequestBody Address address, @RequestParam String key) {
        return addressService.updateAddressByCustom(address.getAddress_id(), key);
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

    @PutMapping("/Admin/updateDoctor")
    public Doctor updateDoctor(@RequestBody Doctor doctor) {

        return doctorServicesImp.updateDoctorDetails("1111",doctor);
    }

    @PutMapping("/Admin/updateCenter")
    public Center updateCenter(@RequestBody Center center) {
        cImpl.saveCenter(center);
        return center;
    }

    @PostMapping("/Admin/createCenter")
    public Center createCenterAddress(@RequestBody Center center) {
        cImpl.saveCenter(center);
        return center;
    }

    @DeleteMapping("/Admin/deleteCenter/{id}")
    public Center deleteCenterUsingId(@PathVariable("id") Integer id) {

        return cImpl.deleteCenterId(id);
    }

    @PostMapping("/Admin/createDoctor")
    public String createDoctor(@RequestBody Doctor doctor) {
        doctorServicesImp.addDoctor(doctor);
        return "Doctor Has Been Added Into DataBase.";
    }

    @DeleteMapping("/Admin/deleteDoctor/{id}")
    public Doctor deleteDoctorUsingId(@PathVariable("id") Integer id) {
        return doctorServicesImp.deleteDoctorById(id);
    }
}
