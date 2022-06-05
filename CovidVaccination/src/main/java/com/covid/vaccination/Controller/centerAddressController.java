package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.centerAddress;
import com.covid.vaccination.Service.centerAddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class centerAddressController {

    @Autowired
    public centerAddressServiceImpl usi;

    @PostMapping("/createCenterAddress")
    public centerAddress createCenterAddress(@RequestBody centerAddress centerAddress) {

        usi.saveCenterAddress(centerAddress);

        return centerAddress;
    }

    @GetMapping("/centerAddress/{id}")
    public centerAddress getCenterAddressById(@PathVariable("id") Integer id) {

        return usi.getCenterAddressById(id);

    }
}
