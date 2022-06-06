package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Address;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Implementation.AddressServiceImpl;
import com.covid.vaccination.Implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    public UserServiceImpl usi;
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

    @PostMapping("/Admin/createAddress")
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
    @DeleteMapping("/Admin/deleteAddress/{id}")
    public Address deleteAddressUsingId(@Valid @PathVariable("id") Integer id){
        return addressService.deleteAddressById(id);
    }
    // Update Address Using KeyaddressService.
    @PutMapping("/Admin/updateAddress")
    public Address updateAddressByUsingId(@Valid @RequestBody Address address, @RequestParam String key){
        return addressService.updateAddressByCustom(address.getAddress_id(), key);
    }
}
