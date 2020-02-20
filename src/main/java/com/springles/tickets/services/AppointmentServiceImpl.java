package com.springles.tickets.services;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

  private AppointmentRepository appointmentRepository;

  @Autowired
  public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
    this.appointmentRepository = appointmentRepository;
  }

  @Override
  public Appointment save(Appointment appointment) {
    appointmentRepository.save(appointment);
    return appointment;
  }
}
