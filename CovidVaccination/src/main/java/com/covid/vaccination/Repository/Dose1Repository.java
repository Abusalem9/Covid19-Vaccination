package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.Dose1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dose1Repository extends JpaRepository<Dose1, Integer> {
   @Query("select u from  Dose1 u where u.user_id=:n")
    Dose1 getDose1ByUser_id(@Param("n") Integer user_id);
}
