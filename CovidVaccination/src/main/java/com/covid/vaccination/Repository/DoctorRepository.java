package com.covid.vaccination.Repository;

import com.covid.vaccination.DTO.BasicUserDetails;
import com.covid.vaccination.Entity.Doctor;
import com.covid.vaccination.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    @Override
      Optional<Doctor> findById(Integer integer);


    //    @Query("select u.user_id,u.firstName,u.firstName,u.mobile,u.dob,u.gender from User u")
//    List<BasicUserDetails> getAllUser();
//    Optional<User> findByMobile(String mobileNo);

}
