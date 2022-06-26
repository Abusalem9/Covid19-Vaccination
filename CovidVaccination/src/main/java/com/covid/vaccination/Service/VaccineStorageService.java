package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.VaccineStorage;

public interface VaccineStorageService {

    VaccineStorage save(VaccineStorage vaccineStorage);
    VaccineStorage updateVaccineStorage(Integer id);
}
