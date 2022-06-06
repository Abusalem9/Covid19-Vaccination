package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.Address;
import com.covid.vaccination.Exception.AddressException;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.AddressRepository;
import com.covid.vaccination.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    public AddressRepository addressRepository;
    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(Integer id) throws AddressException {
        return addressRepository.findById(id).orElseThrow(() -> new UserException("Address does not exist with this Id :" + id));
    }

    @Override
    public Address deleteAddressById(Integer id) throws AddressException {
        Address existingAddress= addressRepository.findById(id).orElseThrow( () -> new UserException("Address does not exist with this Id :"+id) );
        addressRepository.delete(existingAddress);
        return existingAddress;
    }

    @Override
    public Address updateAddress(Address address) throws AddressException {
        Optional<Address> opt= addressRepository.findById(address.getAddress_id());

        if(opt.isPresent()) {
            Address existingAddress= opt.get();
            return addressRepository.save(address);
        }
        else
            throw new AddressException("Invalid Address Details..");
    }

    @Override
    public Address updateAddressByCustom(Integer id, String pinCode) throws AddressException {
        Optional<Address> opt= addressRepository.findById(id);
        if(opt.isPresent()) {
            Address existingAddress= opt.get();
            existingAddress.setPinCode(pinCode);
            return addressRepository.save(existingAddress);
        }else
            throw new AddressException("Address does not exist with this Id :"+id);
    }
}
