package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Address;
import com.covid.vaccination.Repository.AddressRepository;
import com.covid.vaccination.Service.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    @Autowired
    public AddressRepository addressRepository;
    @GetMapping("/address")
    public Address getAddress(){
        return addressRepository.getAllByAddress(1);
    }

    @PutMapping("/updatePinCode/{pin}")
    public String updatePinCode(@PathVariable("pin") String s,@RequestParam Integer id){
        int x= addressRepository.updatePinCode(s,id);
        if(x>0)
            return "Successfully Updated PinCode:"+s;
        else
            return "Failed To Update PinCode:"+s;
    }
    @PutMapping("/updateCity/{city}")
    public String updateCity(@PathVariable("city") String s,@RequestParam Integer id){
        int x= addressRepository.updateCity(s,id);
        if(x>0)
            return "Successfully Updated City :"+s;
        else
            return "Failed To Update City :"+s;
    }
    @PutMapping("/updateState/{state}")
    public String updateState(@PathVariable("state") String s,@RequestParam Integer id){
        int x= addressRepository.updateState(s,id);
        if(x>0)
            return "Successfully Updated State :"+s;
        else
            return "Failed To Update State :"+s;
    }
}
