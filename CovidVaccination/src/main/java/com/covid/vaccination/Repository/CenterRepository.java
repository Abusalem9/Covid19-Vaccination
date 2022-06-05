package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.Center;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepository extends JpaRepository<Center, Integer> {
}
