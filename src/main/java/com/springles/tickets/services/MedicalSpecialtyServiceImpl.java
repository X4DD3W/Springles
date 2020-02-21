package com.springles.tickets.services;

import com.springles.tickets.models.MedicalSpecialty;
import com.springles.tickets.repositories.MedicalSpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalSpecialtyServiceImpl implements MedicalSpecialtyService {
  private MedicalSpecialtyRepository medicalSpecialtyRepository;

  @Autowired
  public MedicalSpecialtyServiceImpl(MedicalSpecialtyRepository medicalSpecialtyRepository) {
    this.medicalSpecialtyRepository = medicalSpecialtyRepository;
  }

  @Override
  public List<MedicalSpecialty> findall(){
    List<MedicalSpecialty> specialties = new ArrayList<>();
    for (MedicalSpecialty medicalSpecialty : medicalSpecialtyRepository.findAll()){
      specialties.add(medicalSpecialty);
    }
    return specialties;
  }
}
