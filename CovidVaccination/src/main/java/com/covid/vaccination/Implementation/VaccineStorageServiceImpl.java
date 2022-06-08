package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.VaccineStorage;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.CenterAddressRepository;
import com.covid.vaccination.Repository.VaccineStorageRepository;
import com.covid.vaccination.Service.VaccineStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        } else throw new UserException("Kindy Enter correct Center ID");
    }
}
