package com.springles.tickets.services;

import com.springles.tickets.repositories.DoctorRepository;
import com.springles.tickets.models.Appointment;
import com.springles.tickets.models.Doctor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

  private DoctorRepository doctorRepository;

  @Autowired
  public DoctorServiceImpl(DoctorRepository doctorRepository) {
    this.doctorRepository = doctorRepository;
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
    return doctorRepository.findById(id).orElse(null);
  }

  @Override
  public List<Doctor> findAll() {
    return (List<Doctor>) doctorRepository.findAll();
  }

  @Override
  public void deleteDoctor(Long id) {
    Doctor doctorToBeDeleted = doctorRepository.findById(id).orElse(null);
    doctorRepository.delete(doctorToBeDeleted);
  }
}
