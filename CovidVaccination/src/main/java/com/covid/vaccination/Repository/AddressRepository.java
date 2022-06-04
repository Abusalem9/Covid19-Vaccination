package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query("select a from Address a inner join User u on  (a.address_id-1)=:n")
    public Address getAllByAddress(@Param("n")Integer integer);
    @Modifying
    @Transactional
    @Query("update Address a set a.pinCode=:n where a.address_id=:id")
    public int updatePinCode(@Param("n") String pinCode,@Param("id")Integer id);

    @Modifying
    @Transactional
    @Query("update Address a set a.city=:n where a.address_id=:id")
    public int updateCity(@Param("n") String pinCode,@Param("id")Integer id);

    @Modifying
    @Transactional
    @Query("update Address a set a.state=:n where a.address_id=:id")
    public int updateState(@Param("n") String pinCode,@Param("id")Integer id);
}
