package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface   UserRepository extends JpaRepository<User, Integer> {
        @Query("select u from User u where u.user_id=:n")
        User getUserById(@Param("n") Integer id);
        Optional<User> findByMobile(String mobileNo);


}
