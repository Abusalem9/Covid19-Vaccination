package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Center;
import com.covid.vaccination.Exception.AddressException;
import com.covid.vaccination.Exception.UserException;

import java.util.List;

public interface centerService {

    Center saveCenter(Center center);

    Center getCenterById(Integer id) throws UserException;

    List<Center> getAllCenter();

    Center updateCenter(Center center) throws UserException;

    Center deleteCenterId(Integer id) throws AddressException;
}
