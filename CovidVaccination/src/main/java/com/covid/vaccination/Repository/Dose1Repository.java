package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.Dose1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dose1Repository extends JpaRepository<Dose1,Integer> {
    public Dose1 getDose1ByUser_id(Integer id);
}
