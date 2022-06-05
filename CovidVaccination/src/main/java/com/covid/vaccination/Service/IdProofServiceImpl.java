package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.IdProof;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.IdProofException;
import com.covid.vaccination.Repository.IdProofRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
@Service
public class IdProofServiceImpl implements IdProofService{
    @Autowired
    public IdProofRepository idProofRepository;

    @Autowired
    private GetCurrentLoginUserSessionDetailsImpl getCurrentLoginIdProof;

    @Override
    public void saveIdProof(IdProof user) {
        idProofRepository.save(user);
    }

    @Override
    @Query("select u from IdProof as u")
    public IdProof getIdProofById(Integer id) throws IdProofException {
        return idProofRepository.findById(id).orElseThrow(() -> new IdProofException("IdProof does not exist with Roll :" + id));
    }

    @Override

    public List<IdProof> getAllIdProofs() throws IdProofException {
        return idProofRepository.findAll();
    }

    @Override
    public IdProof deleteIdProofById(Integer id) throws IdProofException {

        IdProof existingIdProof= idProofRepository.findById(id).orElseThrow( () -> new IdProofException("IdProof does not exist with this Id :"+id) );
        idProofRepository.delete(existingIdProof);
        return existingIdProof;
    }


    @Override
    public IdProof updateIdProof(IdProof user, String key) throws IdProofException {
        User user2 = getCurrentLoginIdProof.getCurrentCustomer(key);

        if (user2 == null) {
            throw new IdProofException("No user found. Please try login first.");
        }
        idProofRepository.save(user);
        return user;
    }
}
