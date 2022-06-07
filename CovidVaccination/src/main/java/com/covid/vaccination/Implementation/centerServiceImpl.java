package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.Center;
import com.covid.vaccination.Exception.AddressException;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.CenterAddressRepository;
import com.covid.vaccination.Repository.CenterRepository;
import com.covid.vaccination.Repository.UserRepository;
import com.covid.vaccination.Service.centerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class centerServiceImpl implements centerService {

    @Autowired
    private CenterRepository centerRepository;

    @Autowired
    private CenterAddressRepository centerAddressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Center saveCenter(Center center) {

        if (centerAddressRepository.existsById(center.getCenterID())) {
            if (userRepository.existsById(center.getUser_Id())) {
                return centerRepository.save(center);
            } else {
                throw new AddressException("No user available for this user Id, kindly check UserId");
            }

        } else {
            throw new AddressException("No center present at this address");
        }


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
