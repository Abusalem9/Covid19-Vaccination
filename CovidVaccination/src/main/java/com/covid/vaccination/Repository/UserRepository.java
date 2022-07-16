package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

        @Query("select u from User  u where u.aadharNo=:n")
        User getUsersByAadharNo(@Param("n")String n);
        @Query("select u from User  u where u.mobile=:n")
        User getUsersByMobileNo(@Param("n")String n);

        @Query("select u from User u,Dose2 d where u.user_id=d.user_id ")
        List<User> getAllBothDoseCompleted();

        Optional<User> findByMobile(String mobileNo);


}
