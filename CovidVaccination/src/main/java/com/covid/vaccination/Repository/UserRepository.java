package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  UserRepository extends JpaRepository<User, Integer> {
        public Optional<User> findById(Integer id);
}
