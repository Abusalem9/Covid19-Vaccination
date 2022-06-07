package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query("select u from  Address u where  u.user_id=:n")
    Optional<Address> findByUser_id(@Param("n") Integer id);
    @Query("select u from  Address u where  u.user_id=:n")
    Optional<Address> deleteByUser_id(@Param("n") Integer id);
}
