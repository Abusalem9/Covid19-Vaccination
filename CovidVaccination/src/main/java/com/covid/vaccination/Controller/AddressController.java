package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Address;
import com.covid.vaccination.Service.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    @Autowired
    public AddressServiceImpl addressService;
    @PostMapping("/createAddress")
    public Address createAddress(@RequestBody Address address){
        addressService.saveAddress(address);
        return address;
    }

    //    get Address Using Address_id
    @GetMapping("/Address/{id}")
    public Address getAddressById(@PathVariable("id") Integer id) {

        return addressService.getAddressById(id);

    }
//    Get All Addresss

    // Delete Address By Id
    @DeleteMapping("/deleteAddress/{id}")
    public Address deleteAddressUsingId(@PathVariable("id") Integer id){
        return addressService.deleteAddressById(id);
    }
    // Update Address Using KeyaddressService.
    @PutMapping("/updateAddress")
    public Address updateAddressByUsingId(@RequestBody Address address, @RequestParam String key){
        return addressService.updateAddressByCustom(address.getAddress_id(), key);
    }
}
