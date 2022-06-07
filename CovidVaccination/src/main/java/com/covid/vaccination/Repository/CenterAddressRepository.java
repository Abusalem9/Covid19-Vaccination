package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.centerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterAddressRepository extends JpaRepository<centerAddress, Integer> {

}
