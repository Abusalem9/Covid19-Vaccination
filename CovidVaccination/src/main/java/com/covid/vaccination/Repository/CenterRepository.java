package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CenterRepository extends JpaRepository<Center, Integer> {

    Optional<Center> findCenterByCenterID(Integer id);
}
