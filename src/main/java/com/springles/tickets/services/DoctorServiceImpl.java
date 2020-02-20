package com.springles.tickets.services;


import com.springles.tickets.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

  private DoctorRepository doctorRepository;

  @Autowired
  public DoctorServiceImpl(DoctorRepository doctorRepository) {
    this.doctorRepository = doctorRepository;
  }
}
