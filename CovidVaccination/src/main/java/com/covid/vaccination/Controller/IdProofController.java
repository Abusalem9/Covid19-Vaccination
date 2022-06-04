package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Address;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Repository.IdProofRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdProofController {

    public IdProofRepository idProofRepository;
    @GetMapping("/getUserByAadhar/{id}")
    public String  getDetailsByAadharNo(@PathVariable("id")String id){
        return idProofRepository.getAllByAadharNo(id);
    }
}
