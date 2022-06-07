package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Appointment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentService {
    public Appointment setAppointment(Appointment appointment);

    public Appointment getAppointmentById(Integer id);
    public Appointment deleteAppointmentById(Integer id);
    public List<Appointment> getAllAppointment();
}
