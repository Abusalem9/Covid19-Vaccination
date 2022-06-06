package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Address;
import com.covid.vaccination.Implementation.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AddressController {
    @Autowired
    public AddressServiceImpl addressService;
    @PostMapping("/createAddress")
    public Address createAddress(@Valid @RequestBody Address address){
        addressService.saveAddress(address);
        return address;
    }

    //    get Address Using Address_id
    @GetMapping("/Address/{id}")
    public Address getAddressById(@Valid @PathVariable("id") Integer id) {

        return addressService.getAddressById(id);

    }

    @DeleteMapping("/deleteAddress/{id}")
    public Address deleteAddressUsingId(@Valid @PathVariable("id") Integer id){
        return addressService.deleteAddressById(id);
    }
    // Update Address Using KeyaddressService.
    @PutMapping("/updateAddress")
    public Address updateAddressByUsingId(@Valid @RequestBody Address address, @RequestParam String key){
        return addressService.updateAddressByCustom(address.getAddress_id(), key);
    }
}
