package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.IdProof;
import com.covid.vaccination.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IdProofRepository extends JpaRepository<IdProof,Integer> {
    @Query("select i.firstName from User i inner join IdProof u on (u.aadharNo)=:n")
    public String  getAllByAadharNo(@Param("n")String no);
}
