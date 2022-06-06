package com.covid.vaccination.Repository;

import com.covid.vaccination.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    @Override
      Optional<Doctor> findById(Integer integer);


    //    @Query("select u.user_id,u.firstName,u.firstName,u.mobile,u.dob,u.gender from User u")
//    List<BasicUserDetails> getAllUser();
//    Optional<User> findByMobile(String mobileNo);

}
