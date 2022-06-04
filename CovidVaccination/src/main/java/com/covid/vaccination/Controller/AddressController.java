package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Address;
import com.covid.vaccination.Service.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    public AddressServiceImpl addressService;
    @GetMapping("/Address/{id}")
    public Address getAddressByUsingId(@PathVariable("id") Integer id){
        return addressService.getAddressById(id);
    }
}
