package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.Address;
import com.covid.vaccination.Entity.IdProof;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Repository.IdProofRepository;
import com.covid.vaccination.Service.IdProofService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
public class IdProofController {
    @Autowired
    public IdProofService idProofService;
    @GetMapping("/getUserAll")
    public List<IdProof> getDetailsByAadharNo(){
        return idProofService.getAllIdProof();
    }
}
