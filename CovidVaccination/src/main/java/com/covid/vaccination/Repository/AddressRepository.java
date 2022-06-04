package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query("select a from Address a inner join User u on  a.address_id=u.user_id")
    public Address getAllByAddress();

}
