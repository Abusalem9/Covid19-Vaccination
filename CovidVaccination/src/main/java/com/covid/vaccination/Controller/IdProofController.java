package com.covid.vaccination.Controller;

import com.covid.vaccination.Entity.IdProof;
import com.covid.vaccination.Service.IdProofService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IdProofController {
    @Autowired
    public IdProofService idProofService;

    @PostMapping("/createIdProof")
    public IdProof createIdProof(@RequestBody IdProof user) {
        idProofService.saveIdProof(user);
        return user;
    }
//methods not requred
    //    get IdProof Using IdProof_id
//    @GetMapping("/IdProof/{id}")
//    public IdProof getIdProofById(@PathVariable("id") Integer id) {
//
//        return idProofService.getIdProofById(id);
//
//    }
//    Get All IdProofs

    //    @GetMapping("/IdProofs")
//    public List<IdProof> getAllIdProofFromDB(){
//        return idProofService.getAllIdProofs();
//    }
    // Delete IdProof By Id
//    @DeleteMapping("/deleteIdProof/{id}")
//    public IdProof deleteIdProofUsingId(@PathVariable("id") Integer id){
//        return idProofService.deleteIdProofById(id);
//    }
    // Update IdProof Using Key.
    @PutMapping("/updateIdProof")
    public IdProof updateIdProofByUsingId(@RequestBody IdProof user, @RequestParam String key) {
        return idProofService.updateIdProof(user, key);
    }
}
