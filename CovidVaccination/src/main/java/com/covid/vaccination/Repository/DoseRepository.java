package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.Dose;
import com.covid.vaccination.Entity.Dose2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer> {
    @Query("select u from  Dose u where u.user_id=:n")
    Dose getDoseByUser_id(@Param("n") Integer user_id);
}
