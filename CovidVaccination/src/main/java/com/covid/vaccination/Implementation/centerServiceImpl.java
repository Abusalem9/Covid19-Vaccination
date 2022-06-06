package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.Center;
import com.covid.vaccination.Exception.AddressException;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.CenterRepository;
import com.covid.vaccination.Service.centerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class centerServiceImpl implements centerService {

    @Autowired
    private CenterRepository centerRepository;

    @Override
    public Center saveCenter(Center center) {
        return centerRepository.save(center);
    }

    @Override
    public Center getCenterById(Integer id) throws UserException {
        return centerRepository.findById(id).orElseThrow(() -> new UserException("Address does not exist with this Id :" + id));
    }

    @Override
    public List<Center> getAllCenter() {
        return centerRepository.findAll();
    }


    @Override
    public Center updateCenter(Center center) throws UserException {

        Center center2 = getCenterById(center.getCenterID());

        if (center2 == null) {
            throw new UserException("No user found. Please try login first.");
        }
        centerRepository.save(center);
        return center;
    }

    @Override
    public Center deleteCenterId(Integer id) throws AddressException {
        Center existingCenter = centerRepository.findById(id).orElseThrow(() -> new UserException("User does not exist with this Id :" + id));
        centerRepository.delete(existingCenter);
        return existingCenter;
    }
}
