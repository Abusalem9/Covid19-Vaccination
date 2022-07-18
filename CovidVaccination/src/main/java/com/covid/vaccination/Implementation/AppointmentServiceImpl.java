package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.Appointment;
import com.covid.vaccination.Entity.UserLogin;
import com.covid.vaccination.Entity.VaccineStorage;
import com.covid.vaccination.Exception.UserAlreadyExistWithMobileNumber;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.*;
import com.covid.vaccination.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    public AppointmentRepository appointmentRepository;

    @Autowired
    public UserServiceImpl userService;

    @Autowired
    public Dose1Repository dose1Repository;
    @Autowired
    public Dose2Repository dose2Repository;

    @Autowired
    CenterAddressRepository centerAddressRepository;

    @Autowired
    VaccineStorageRepository vaccineStorageRepository;
    @Autowired
    public UserLoginRepository userLoginRepository;

    @Override
    public ResponseEntity<Appointment> setAppointment(Appointment appointment) {
        UserLogin userLogin= userLoginRepository.getUserLoginByMobile(userService.getUserById(appointment.getUser_id()).getMobile());
        if(userLogin!=null){
            if (centerAddressRepository.existsById(appointment.getCenter_id())) {
                VaccineStorage v=vaccineStorageRepository.findByCenterID(appointment.getCenter_id());
                if(v.getAvailableStock()<=0 || v==null){
                    throw new UserAlreadyExistWithMobileNumber("No vaccine Available at this Center");
                }
                if (userService.getUserById(appointment.getUser_id()).getPassword().equals(appointment.getPassword())) {
                    if (dose2Repository.getDose2ByUser_id(appointment.getUser_id()) != null) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Already User Has Taken Both Doses.");
                    }
                    Appointment optional = appointmentRepository.findByUser_id(appointment.getUser_id());
                    if (optional == null) {
                        Appointment result = appointmentRepository.save(appointment);
                        return new ResponseEntity<>(result, HttpStatus.OK);
                    } else
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Already Generated an Appointment Please Wait for Doctor Approval.");

                } else
                    throw new UserAlreadyExistWithMobileNumber("Please Fill Correct User Id & Password");
            } else {
                throw new UserAlreadyExistWithMobileNumber("No center available with this center Id, Kindly enter correct center ID");
            }
        }
        else
            throw new UserAlreadyExistWithMobileNumber("Please Login First.");

    }

    @Override
    public ResponseEntity<Appointment> getAppointmentById(Integer id) {
        Appointment result= appointmentRepository.findById(id).orElseThrow(() -> new UserException("User does not exist with User Id :" + id));

       return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Appointment> deleteAppointmentById(Integer id) {
        Appointment existingUser= appointmentRepository.findById(id).orElseThrow( () -> new UserException("User does not exist with this UserId :"+id) );
        appointmentRepository.delete(existingUser);
        return new ResponseEntity<>(existingUser,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Appointment>> getAllAppointment() {

        return new ResponseEntity<>(appointmentRepository.findAll(),HttpStatus.OK);
    }
}
