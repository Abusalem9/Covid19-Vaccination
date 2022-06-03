package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Address;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressServiceImpl implements AddressService{
    @Autowired
    public AddressRepository addressRepository;
    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddress(Integer id) {
        return addressRepository.findById(id).orElseThrow(() -> new UserException("User does not exist with Roll :"+id));
    }

}
