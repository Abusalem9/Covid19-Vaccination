package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.centerAddress;
import com.covid.vaccination.Service.centerAdressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class centerAddressController {

    @Autowired
    public centerAdressServiceImpl usi;

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
