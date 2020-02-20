package com.springles.tickets.services;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.models.Doctor;
import com.springles.tickets.repositories.DoctorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

  @Autowired
  DoctorRepository doctorRepository;

  public DoctorServiceImpl(DoctorRepository doctorRepository){
    this.doctorRepository = doctorRepository;
  }

  @Override
  public void save(Doctor doctor) {
    doctorRepository.save(doctor);
  }

  @Override
  public List<Appointment> getListOfAppointments(String name) {
    Doctor searchedDoctor = doctorRepository.findByName(name);
    return searchedDoctor.getListOfAppointments();
  }


}
