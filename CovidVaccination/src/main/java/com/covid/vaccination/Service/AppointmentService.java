package com.covid.vaccination.Service;

import com.covid.vaccination.Entity.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppointmentService {
    public ResponseEntity<Appointment> setAppointment(Appointment appointment);

    public ResponseEntity<Appointment> getAppointmentById(Integer id);

    public ResponseEntity<Appointment> deleteAppointmentById(Integer id);

    public ResponseEntity<List<Appointment>> getAllAppointment();

}





