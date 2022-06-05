package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.Optional;
@Repository
public interface SessionRepository extends JpaRepository<CurrentUserSession, Id> {
    Optional<CurrentUserSession> findById(Integer id);
    Optional<CurrentUserSession> findByUuid(String uuid);
}
