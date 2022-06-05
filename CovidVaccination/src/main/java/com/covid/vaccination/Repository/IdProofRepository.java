package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.IdProof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface IdProofRepository extends JpaRepository<IdProof,Integer> {
}
