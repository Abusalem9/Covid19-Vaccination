package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Center;
import com.covid.vaccination.Exception.UserException;

public interface centerService {

    Center saveCenter(Center center);

    Center getCenterById(Integer id) throws UserException;
}
