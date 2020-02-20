package com.springles.tickets.services;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.repositories.AppointmentRepository;
import java.util.ArrayList;
import java.util.List;
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

  @Override
  public List<Appointment> findAll() {
    List<Appointment> appointments = new ArrayList<>();
    appointmentRepository.findAll().forEach(appointments::add);
    return appointments;
  }

  @Override
  public boolean isThisAppointmentAvailable(Appointment appointment) {
    List<Appointment> appointments = appointmentRepository.findAll();
    if (!appointments.isEmpty()) {
      for (int i = 0; i < appointments.size(); i++) {
        if (appointments.get(i).getDate() == appointment.getDate()) {
          return true;
        }
      }
    }
    return false;
  }
}
