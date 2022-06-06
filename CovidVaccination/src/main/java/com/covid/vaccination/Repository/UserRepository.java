package com.covid.vaccination.Repository;

import com.covid.vaccination.DTO.BasicUserDetails;
import com.covid.vaccination.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface   UserRepository extends JpaRepository<User, Integer> {
        @Query("select u from User u where u.user_id=:n")
        User getUserById(@Param("n") Integer id);
        @Query("select u.user_id,u.firstName,u.firstName,u.mobile,u.dob,u.gender from User u")
        List<BasicUserDetails> getAllUser();
        Optional<User> findByMobile(String mobileNo);


}
