package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Dose;
import com.covid.vaccination.Entity.Dose;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.DoseException;
import com.covid.vaccination.Exception.DoseException;
import com.covid.vaccination.Repository.DoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoseServiceImpl implements DoseService{
    @Autowired
    public DoseRepository doseRepository;
    @Autowired
    private GetCurrentLoginUserSessionDetailsImpl getCurrentLoginUser;
    @Override
    public void saveDose(Dose user) {
        doseRepository.findById(user.getUser_id()).isPresent(() -> new DoseException("Dose does not exist with Roll :" + user.getUser_id()));
        doseRepository.save(user);
    }

    @Override
    @Query("select u from Dose as u")
    public Dose getDoseById(Integer id) throws DoseException {
        return doseRepository.findById(id).orElseThrow(() -> new DoseException("Dose does not exist with Roll :" + id));
    }

    @Override

    public List<Dose> getAllDoses() throws DoseException {
        return doseRepository.findAll();
    }

    @Override
    public Dose deleteDoseById(Integer id) throws DoseException {

        Dose existingDose= doseRepository.findById(id).orElseThrow( () -> new DoseException("Dose does not exist with this Id :"+id) );
        doseRepository.delete(existingDose);
        return existingDose;
    }


    @Override
    public Dose updateDose(Dose user, String key) throws DoseException {
        User user2 = getCurrentLoginUser.getCurrentCustomer(key);

        if (user2 == null) {
            throw new DoseException("No user found. Please try login first.");
        }
        doseRepository.save(user);
        return user;
    }
}
