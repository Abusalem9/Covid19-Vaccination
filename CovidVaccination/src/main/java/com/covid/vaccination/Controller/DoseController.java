package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Dose;
import com.covid.vaccination.Service.DoseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoseController {
    @Autowired
    public DoseServiceImpl usi;

    //    Create Dose
    @PostMapping("/createDose")
    public Dose createDose(@RequestBody Dose user){
        usi.saveDose(user);
        return user;
    }

    //    get Dose Using Dose_id
    @GetMapping("/Dose/{id}")
    public Dose getDoseById(@PathVariable("id") Integer id) {

        return usi.getDoseById(id);

    }
//    Get All Doses

    @GetMapping("/Doses")
    public List<Dose> getAllDoseFromDB(){
        return usi.getAllDoses();
    }
    // Delete Dose By Id
    @DeleteMapping("/deleteDose/{id}")
    public Dose deleteDoseUsingId(@PathVariable("id") Integer id){
        return usi.deleteDoseById(id);
    }
    // Update Dose Using Key.
    @PutMapping("/updateDose")
    public Dose updateDoseByUsingId(@RequestBody Dose user,@RequestParam String key){
        return usi.updateDose(user,key);
    }
}
