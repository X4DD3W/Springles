package com.springles.tickets.services;

import com.springles.tickets.models.Appointment;

import java.util.ArrayList;
import java.util.List;

public interface AppointmentService {

  Appointment save(Appointment appointment);

  List<Appointment> listAll();

  List<Appointment> listUnpairedAppointments();

  List<Appointment> listPairedAppointments();

  List<Appointment> filteredAppointmentsByName(List<Appointment> appointments, String name);

  List<Appointment> filteredAppointmentsBySpecialty(List<Appointment> appointments,
      String specialty);
}
