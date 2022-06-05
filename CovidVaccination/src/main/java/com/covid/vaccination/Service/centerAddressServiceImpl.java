package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.centerAddress;
import com.covid.vaccination.Exception.AddressException;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.CenterAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class centerAddressServiceImpl implements centerAddressService {

    @Autowired
    public CenterAddressRepository centisteradianRepository;


    @Override
    public centerAddress saveCenterAddress(centerAddress centeraddress) {
        return centisteradianRepository.save(centeraddress);
    }

    @Override
    public centerAddress getCenterAddressById(Integer id) throws AddressException {
        return centisteradianRepository.findById(id).orElseThrow(() -> new UserException("Address does not exist with this Id :" + id));
    }
}
