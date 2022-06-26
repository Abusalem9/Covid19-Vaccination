package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.Dose1;
import com.covid.vaccination.Repository.Dose1Repository;
import com.covid.vaccination.Service.Dose1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Dose1ServiceImpl implements Dose1Service {
    @Autowired
    public Dose1Repository dose1Repository;
    @Override
    public List<Dose1> getAllUser() {
        return dose1Repository.findAll();
    }

}
