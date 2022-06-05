package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Center;
import com.covid.vaccination.Service.centerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class centerController {

    @Autowired
    public centerServiceImpl cImpl;

    @PostMapping("/createCenter")
    public Center createCenterAddress(@RequestBody Center center) {

        cImpl.saveCenter(center);

        return center;
    }

    @GetMapping("/centerAddress/{id}")
    public Center getCenterAddressById(@PathVariable("id") Integer id) {

        return cImpl.getCenterById(id);

    }
}
