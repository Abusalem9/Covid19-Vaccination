package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.centerAddress;
import com.covid.vaccination.Exception.AddressException;
import com.covid.vaccination.Repository.CenterAddressRepository;
import com.covid.vaccination.Service.centerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterCreationServiceImpl implements centerAddressService {


    @Autowired
    public CenterAddressRepository centerAddressRepository;



    @Override
    public centerAddress saveCenterAddress(centerAddress centeraddress) {

        return centerAddressRepository.save(centeraddress);

    }

    @Override
    public centerAddress getCenterAddressById(Integer id) throws AddressException {
        return centerAddressRepository.findById(id).orElseThrow(() -> new AddressException("Address does not exist with this Id :" + id));
    }

    @Override
    public centerAddress deleteCenterById(Integer id) throws AddressException {
        centerAddress existingcenterAddress= centerAddressRepository.findById(id).orElseThrow( () -> new AddressException("centerAddress does not exist with this Id :"+id) );
        centerAddressRepository.delete(existingcenterAddress);
        return existingcenterAddress;
    }

    @Override
    public centerAddress updateCenterAddress(centerAddress centerAddress) throws AddressException {
        centerAddress existingcenterAddress= centerAddressRepository.findById(centerAddress.getCenterID()).orElseThrow( () -> new AddressException("centerAddress does not exist with this Id :"+centerAddress.getCenterID()) );
        return centerAddressRepository.save(existingcenterAddress);
    }

    @Override
    public List<centerAddress> getAllCenterList() {
        return centerAddressRepository.findAll();
    }
}
