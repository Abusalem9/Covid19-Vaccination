package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.VaccineStorage;
import com.covid.vaccination.Exception.UserAlreadyExistWithMobileNumber;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.CenterAddressRepository;
import com.covid.vaccination.Repository.VaccineStorageRepository;
import com.covid.vaccination.Service.VaccineStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VaccineStorageServiceImpl implements VaccineStorageService {

    @Autowired
    private VaccineStorageRepository vaccineStorageRepository;

    @Autowired
    private CenterAddressRepository centerAddressRepository;

    @Override
    public VaccineStorage save(VaccineStorage vaccineStorage) {

        if (centerAddressRepository.existsById(vaccineStorage.getCenterID())) {
            vaccineStorageRepository.save(vaccineStorage);
            return vaccineStorage;
        } else throw new UserException(" Kindly Enter correct Center ID");
    }

    @Override
    public VaccineStorage updateVaccineStorage(Integer id) {
           VaccineStorage v=vaccineStorageRepository.findByCenterID(id);
            if(v!=null) {
                v.setAvailableStock(v.getAvailableStock()-1);
                return vaccineStorageRepository.save(v);
            }else
                throw new UserAlreadyExistWithMobileNumber("Please Check Center Id");
    }
}
