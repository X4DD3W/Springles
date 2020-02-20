package com.springles.tickets.services;

import com.springles.tickets.models.Appointment;
import java.util.List;

public interface AppointmentService {

  Appointment save(Appointment appointment);

  List<Appointment> findAll();

  boolean isThisAppointmentAvailable(Appointment appointment);
}
