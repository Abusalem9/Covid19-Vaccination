package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.IdProof;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.IdProofRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
@Service
public class IdProofServiceImpl implements IdProofService{
    @Autowired
    public IdProofRepository idProofRepository;


    @Override
    public List<IdProof> getAllIdProof() throws UserException {
        return idProofRepository.findAll();
    }
}
