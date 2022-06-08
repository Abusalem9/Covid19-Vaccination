package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.Appointment;
import com.covid.vaccination.Entity.Dose1;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserAlreadyExistWithMobileNumber;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.AppointmentRepository;
import com.covid.vaccination.Repository.Dose1Repository;
import com.covid.vaccination.Repository.Dose2Repository;
import com.covid.vaccination.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    public AppointmentRepository appointmentRepository;

    @Autowired
    public  UserServiceImpl userService;

    @Autowired
    public Dose1Repository dose1Repository;
    @Autowired
    public Dose2Repository dose2Repository;

    @Override
    public Appointment setAppointment(Appointment appointment) {
        if (dose2Repository.getDose2ByUser_id(appointment.getUser_id())!=null){
            throw new UserAlreadyExistWithMobileNumber("Already User Has Taken Both Doses.");
        }
        Appointment optional=appointmentRepository.findByUser_id(appointment.getUser_id());
        if (optional==null){
            return appointmentRepository.save(appointment);
        }
        else
            throw new UserAlreadyExistWithMobileNumber("User Already Generated an Appointment Please Wait for Doctor Approval.");
    }

    @Override
    public Appointment getAppointmentById(Integer id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new UserException("User does not exist with User Id :" + id));
    }

    @Override
    public Appointment deleteAppointmentById(Integer id) {
        Appointment existingUser= appointmentRepository.findById(id).orElseThrow( () -> new UserException("User does not exist with this Id :"+id) );
        appointmentRepository.delete(existingUser);
        return existingUser;
    }

    @Override
    public List<Appointment> getAllAppointment() {
        return appointmentRepository.findAll();
    }
}
