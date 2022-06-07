package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.Dose2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Dose2Repository extends JpaRepository<Dose2,Integer> {


    @Query("select u from  Dose2 u where u.user_id=:n")
    Dose2 getDose2ByUser_id(@Param("n") Integer user_id);
}
