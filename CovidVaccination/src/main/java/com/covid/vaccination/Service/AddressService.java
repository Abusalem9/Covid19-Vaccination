package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Address;
import com.covid.vaccination.Exception.AddressException;


public interface AddressService {
    Address saveAddress(Address address);
    Address getAddressById(Integer id) throws AddressException;
    Address deleteAddressById(Integer id) throws AddressException;
    public Address updateAddress(Address address)throws AddressException;
    public Address updateAddressByCustom(Integer id, String pinCode)throws AddressException;
}
