package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.centerAddress;
import com.covid.vaccination.Exception.AddressException;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.CenterAddressRepository;
import com.covid.vaccination.Repository.CenterRepository;
import com.covid.vaccination.Service.centerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class centerCreationServiceImpl implements centerAddressService {


    @Autowired
    public CenterAddressRepository centisteradianRepository;

    @Autowired
    public CenterRepository centerRepository;

    @Override
    public centerAddress saveCenterAddress(centerAddress centeraddress) {

        return centisteradianRepository.save(centeraddress);

    }

    @Override
    public centerAddress getCenterAddressById(Integer id) throws AddressException {
        return centisteradianRepository.findById(id).orElseThrow(() -> new UserException("Address does not exist with this Id :" + id));
    }
}
