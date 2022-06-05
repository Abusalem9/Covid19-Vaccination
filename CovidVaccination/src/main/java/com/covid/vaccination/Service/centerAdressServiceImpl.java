package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.centerAddress;
import com.covid.vaccination.Exception.AddressException;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.CenterAddresRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class centerAdressServiceImpl implements centerAddressService {

    @Autowired
    public CenterAddresRepository centeraddresRepository;


    @Override
    public centerAddress saveCenterAddress(centerAddress centeraddress) {
        return centeraddresRepository.save(centeraddress);
    }

    @Override
    public centerAddress getCenterAddressById(Integer id) throws AddressException {
        return centeraddresRepository.findById(id).orElseThrow(() -> new UserException("Address does not exist with this Id :" + id));
    }
}
