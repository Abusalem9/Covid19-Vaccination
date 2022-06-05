package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.centerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterAddresRepository extends JpaRepository<centerAddress, Integer> {
}
