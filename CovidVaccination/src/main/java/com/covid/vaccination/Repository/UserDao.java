package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    Optional<User> findByMobile(String mobileNo);
}
