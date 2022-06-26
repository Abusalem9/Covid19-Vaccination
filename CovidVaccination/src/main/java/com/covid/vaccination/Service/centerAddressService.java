package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.centerAddress;
import com.covid.vaccination.Exception.AddressException;

import javax.validation.constraints.Max;
import java.util.List;

public interface centerAddressService {

    centerAddress saveCenterAddress(centerAddress centeraddress);

    centerAddress getCenterAddressById(Integer id) throws AddressException;
    centerAddress deleteCenterById(Integer id)throws AddressException;
    centerAddress updateCenterAddress(centerAddress centerAddress)throws AddressException;

    List<centerAddress> getAllCenterList();
}
