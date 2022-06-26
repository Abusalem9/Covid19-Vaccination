package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.DoctorDoseGeneration;
import com.covid.vaccination.Entity.Dose1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseGenerationRepository extends JpaRepository<DoctorDoseGeneration,Integer> {
}
