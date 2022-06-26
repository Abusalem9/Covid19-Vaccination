package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin,Integer> {
    @Query("select u from UserLogin u where u.mobile=:n")
    public UserLogin getUserLoginByMobile(@Param("n") String id);
}
