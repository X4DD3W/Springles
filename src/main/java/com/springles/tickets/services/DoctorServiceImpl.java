package com.springles.tickets.services;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.models.Doctor;
import com.springles.tickets.repositories.AppointmentRepository;
import com.springles.tickets.repositories.DoctorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

  @Autowired
  private DoctorRepository doctorRepository;
  private AppointmentRepository appointmentRepository;

  public DoctorServiceImpl(DoctorRepository doctorRepository, AppointmentRepository appointmentRepository) {
    this.doctorRepository = doctorRepository;
    this.appointmentRepository = appointmentRepository;
  }

  @Override
  public void save(Doctor doctor) {
    doctorRepository.save(doctor);
  }

  @Override
  public List<Appointment> getListOfAppointments(Long id) {
    Doctor searchedDoctor = doctorRepository.findById(id).orElse(null);
    return searchedDoctor.getListOfAppointments();
  }

  @Override
  public Doctor findById(Long id) {
    Doctor doctor = doctorRepository.findById(id).orElse(null);
    return doctor;
  }

  @Override
  public List<Doctor> findAll() {
    List<Doctor> listOfDoctors = (List<Doctor>) doctorRepository.findAll();
    return listOfDoctors;
  }


}
