package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.centerAddress;
import com.covid.vaccination.Exception.AddressException;

public interface centerAddressService {

    centerAddress saveCenterAddress(centerAddress centeraddress);

    centerAddress getCenterAddressById(Integer id) throws AddressException;
}
