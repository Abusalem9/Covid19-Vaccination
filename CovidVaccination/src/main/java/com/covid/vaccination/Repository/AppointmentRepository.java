package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.Appointment;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
   @Query("select u from Appointment  u where  u.user_id=:n")
    public Appointment findByUser_id(@Param("n") Integer id);
}
