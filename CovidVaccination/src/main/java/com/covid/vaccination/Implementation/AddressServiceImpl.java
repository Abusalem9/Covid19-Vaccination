package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.Address;
import com.covid.vaccination.Entity.CurrentUserSession;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.*;
import com.covid.vaccination.Repository.AddressRepository;
import com.covid.vaccination.Repository.UserRepository;
import com.covid.vaccination.Repository.UserSessionRepository;
import com.covid.vaccination.Service.AddressService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    public AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public Address saveAddress(Address address) {
        User u=userRepository.getUserById(address.getUser_id());
        if(u!=null){
            return addressRepository.save(address);
        }
        else {
                throw  new UserAlreadyExistWithMobileNumber("Please Check User Id");
        }
    }

    @Override
    public Address getAddressById(Integer id) throws AddressException {
        Optional<Address> address=addressRepository.findByUser_id(id);
        if(address.isPresent()){
            return address.get();
        }
        else
            throw  new UserAlreadyExistWithMobileNumber("Please Check User Id");
    }

    @Override
    public Address deleteAddressById(Integer id) throws AddressException {
            Address existingAddress= addressRepository.findByUser_id(id).orElseThrow( () -> new UserException("Address does not exist with this Id :"+id) );
            addressRepository.delete(existingAddress);
            return existingAddress;

    }

    @Override
    public Address updateAddress(Address address) throws AddressException {
        Optional<Address> opt= addressRepository.findByUser_id(address.getUser_id());

        if(opt.isPresent()) {
            return addressRepository.save(address);
        }
        else
            throw new AddressException("Invalid Address Details..");
    }

    @Override
    public Address updateAddressByCustom(Integer id, String pinCode) throws AddressException {
        Optional<Address> opt= addressRepository.findByUser_id(id);
        if(opt.isPresent()) {
            Address existingAddress= opt.get();
            existingAddress.setPinCode(pinCode);
            return addressRepository.save(existingAddress);
        }else
            throw new AddressException("Address does not exist with this User Id :"+id);
    }
}
