package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.Dose1;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.Dose1Repository;
import com.covid.vaccination.Service.Dose1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Dose1Impl implements Dose1Service {
    @Autowired
    public Dose1Repository dose1Repository;
    @Override
    public List<Dose1> getAllUser() {
        return dose1Repository.findAll();
    }
    @Override
    public Dose1 getUserById(Integer id) throws UserException {
        return dose1Repository.getDose1ByUser_id(id);
    }

}
