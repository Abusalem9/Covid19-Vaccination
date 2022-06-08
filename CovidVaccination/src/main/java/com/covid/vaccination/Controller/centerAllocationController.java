package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Center;
import com.covid.vaccination.Implementation.centerAllocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class centerAllocationController {

    @Autowired
    public centerAllocationServiceImpl cImpl1;

    @PostMapping("/allocateCenter")
    public ResponseEntity<Center> allocateCenter(@RequestBody Center center) {

        cImpl1.saveCenter(center);

        return new ResponseEntity<>(center, HttpStatus.OK);
    }


}
