package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
     Doctor findByDoctorId(Integer doctorId);
     Optional<Doctor> findByMobile(String mobileNo);
     @Query("select  d from  Doctor d where  d.doctorId=:n")
     Doctor getDoctorByDoctorId(@Param("n")Integer id);
}
