package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.centerAddress;
import com.covid.vaccination.Implementation.centerCreationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class centerCreationController {

    @Autowired
    public centerCreationServiceImpl usi;


    @PostMapping("/createCenter")
    public centerAddress createCenter(@RequestBody centerAddress centerAddress) {


        usi.saveCenterAddress(centerAddress);

        return centerAddress;
    }
}

