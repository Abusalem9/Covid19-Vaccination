package com.covid.vaccination.Implementation;

import com.covid.vaccination.Entity.Appointment;
import com.covid.vaccination.Entity.User;
import com.covid.vaccination.Exception.UserAlreadyExistWithMobileNumber;
import com.covid.vaccination.Exception.UserException;
import com.covid.vaccination.Repository.AppointmentRepository;
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
    @Override
    public Appointment setAppointment(Appointment appointment) {
        userService.getUserById(appointment.getUser_id());
        Appointment optional=appointmentRepository.findByUser_id(appointment.getUser_id());
        if (optional!=null){
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
