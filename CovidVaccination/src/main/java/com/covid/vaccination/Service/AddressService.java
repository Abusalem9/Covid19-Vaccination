package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Address;

public interface AddressService {
    public Address saveAddress(Address address);
    public Address getAddress(Integer id);
}
