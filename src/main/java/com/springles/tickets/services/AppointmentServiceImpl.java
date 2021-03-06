package com.springles.tickets.services;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.models.Doctor;
import com.springles.tickets.models.MedicalSpecialty;
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
  public List<Appointment> listAll() {
    return new ArrayList<>(appointmentRepository.findAll());
  }

  @Override
  public List<Appointment> listUnpairedAppointments() {
    List<Appointment> appointments = new ArrayList<>();
    for (Appointment appointment : appointmentRepository.findAll()) {
      if (appointment.getDoctor() == null) {
        appointments.add(appointment);
      }
    }
    return appointments;
  }

  @Override
  public List<Appointment> listPairedAppointments() {
    List<Appointment> appointments = new ArrayList<>();
    for (Appointment appointment : appointmentRepository.findAll()) {
      if (appointment.getDoctor() != null) {
        appointments.add(appointment);
      }
    }
    return appointments;
  }

  @Override
  public boolean isThisAppointmentAvailable(Appointment appointment) {
    List<Appointment> appointments = appointmentRepository.findAll();
    if (!appointments.isEmpty()) {
      for (Appointment value : appointments) {
        if (value.getDate().equals(appointment.getDate())) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public List<Appointment> filteredAppointmentsByName(List<Appointment> appointments, String name) {
    List<Appointment> filteredAppointments = new ArrayList<>();
    for (Appointment appointment : appointments) {
      if (appointment.getDoctor() != null) {
        if (appointment.getDoctor().getName().equals(name)) {
          filteredAppointments.add(appointment);
        }
      }
    }
    return filteredAppointments;
  }

  @Override
  public List<Appointment> filteredAppointmentsBySpecialty(List<Appointment> appointments,
                                                           String specialty) {
    List<Appointment> filteredAppointments = new ArrayList<>();
    for (Appointment appointment : appointments) {
      if (appointment.getSpecialist().equals(specialty)) {
        filteredAppointments.add(appointment);
      }
    }
    return filteredAppointments;
  }

  @Override
  public void deleteAppointment(Long id) {
    appointmentRepository.deleteById(id);
  }

  @Override
  public Appointment findById(Long id) {
    return appointmentRepository.findById(id).orElse(null);
  }

  @Override
  public boolean isDoctorHasTheSpecialty(String specialty, Doctor doctor) {
    boolean hasSpecialty = false;
    for (MedicalSpecialty specialtyOfDoc : doctor.getListOfMedicalSpecialties()) {
      if (specialtyOfDoc.getNameOfSpecialty().equals(specialty)) {
        hasSpecialty = true;
      }
    }
    return hasSpecialty;
  }
}
