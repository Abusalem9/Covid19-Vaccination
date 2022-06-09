package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.DoctorLogin;
import com.covid.vaccination.Entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorLoginRepository extends JpaRepository<DoctorLogin,Integer> {
    @Query("select u from DoctorLogin u where u.mobile=:n")
    public DoctorLogin getDoctorLoginByMobile(@Param("n") String id);
}
