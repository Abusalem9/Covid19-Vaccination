package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Address;
import com.covid.vaccination.Repository.AddressRepository;
import com.covid.vaccination.Service.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    @Autowired
    public AddressRepository addressRepository;
    @GetMapping("/address")
    public Address getAddress(){
        return addressRepository.getAllByAddress();
    }
    @PostMapping("/createAddress")
    public Address createAddress(@RequestBody Address address){
        return addressRepository.save(address);
    }
}
