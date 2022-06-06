package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Implementation.DoctorServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DoctorController {

    @Autowired

    private DoctorServicesImp dsi;


        //  Add doctors
        @PostMapping("/addDoctor")
        public String createUser(@RequestBody Doctor doctor){
            dsi.addDoctor(doctor);
            return "Doctor Has Been Added Successfully.";
        }

    //    get doctors using doctorId;
    @GetMapping("/doctor/{did}")
    public Doctor getDoctorById(@PathVariable("did") Integer id) {

        return dsi.getDoctor(id);

    }
//    Get All doctors
    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors(){
         return dsi.getAllDoctors();
    }

//    // Delete User By Id
//    @DeleteMapping("/deleteUser/{id}")
//    public User deleteUserUsingId(@PathVariable("id") Integer id){
//        return usi.deleteUserById(id);
//    }


    // Update Doctor Details Using Key.
    @PutMapping("/updateDoctor")
    public Doctor updateDoctorDetails(@RequestParam String key,@RequestBody Doctor newDoctor) {

        return null;

    }

    }



