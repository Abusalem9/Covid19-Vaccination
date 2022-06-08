package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.VaccineStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineStorageRepository extends JpaRepository<VaccineStorage, Integer> {
}
