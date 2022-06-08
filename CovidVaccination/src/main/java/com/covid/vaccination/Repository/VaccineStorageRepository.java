package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.VaccineStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineStorageRepository extends JpaRepository<VaccineStorage, Integer> {
    @Query("select v from VaccineStorage v where v.centerID=:n")
    VaccineStorage findByCenterID(@Param("n")Integer id);
}
