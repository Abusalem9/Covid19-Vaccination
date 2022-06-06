package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Dose1;
import com.covid.vaccination.Repository.Dose1Repository;

import java.util.List;

public interface Dose1Service {
    public List<Dose1> getAllUser();
    public Dose1 getUserById(Integer id);

}
