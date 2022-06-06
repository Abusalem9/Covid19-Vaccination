package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Center;
import com.covid.vaccination.Implementation.centerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class centerController {

    @Autowired
    public centerServiceImpl cImpl1;

    @PostMapping("/createCenter")
    public Center createCenterAddress(@RequestBody Center center) {

        cImpl1.saveCenter(center);

        return center;
    }


}
