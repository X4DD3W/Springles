package com.springles.tickets.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MedicalSpecialty {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nameOfSpecialty;

  @ManyToOne
  private Doctor doctor;

  public MedicalSpecialty() {
  }

  public MedicalSpecialty(String nameOfSpecialty) {
    this.nameOfSpecialty = nameOfSpecialty;
  }

  public Long getId() {
    return id;
  }

  public String getNameOfSpecialty() {
    return nameOfSpecialty;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setNameOfSpecialty(String nameOfSpecialty) {
    this.nameOfSpecialty = nameOfSpecialty;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }
}
