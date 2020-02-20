package com.springles.tickets.services;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.models.Doctor;
import java.util.List;

public interface DoctorService {

  void save(Doctor doctor);

  List<Appointment> getListOfAppointments(Long id);

  Doctor findById(Long id);

  List<Doctor> findAll();
}
