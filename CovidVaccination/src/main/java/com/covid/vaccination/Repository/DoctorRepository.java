package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
     Optional<Doctor> findDoctorByDoctorId(Integer doctorId);

}
