package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.IdProof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdProofRepository extends JpaRepository<IdProof,Integer> {
}
