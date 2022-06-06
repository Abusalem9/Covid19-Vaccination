package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Center;
import com.covid.vaccination.Implementation.centerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class centerController {

    @Autowired
    public centerServiceImpl cImpl;

    @PostMapping("/createCenter")
    public Center createCenterAddress(@RequestBody Center center) {

        cImpl.saveCenter(center);

        return center;
    }

    @GetMapping("/getCenter/{id}")
    public Center getCenterAddressById(@PathVariable("id") Integer id) {

        return cImpl.getCenterById(id);

    }
}
