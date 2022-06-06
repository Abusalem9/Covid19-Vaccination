package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.centerAddress;
import com.covid.vaccination.Implementation.centerAddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class centerAddressController {

    @Autowired
    public centerAddressServiceImpl usi;

    @PostMapping("/createCenterAddress")
    public centerAddress createCenterAddress(@RequestBody centerAddress centerAddress) {

        usi.saveCenterAddress(centerAddress);

        return centerAddress;
    }
}

