package com.springles.tickets.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MedicalSpecialty {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nameOfSpecialty;

  public MedicalSpecialty(){}

  public MedicalSpecialty(String nameOfSpecialty){
    this.nameOfSpecialty = nameOfSpecialty;
  }

  public Long getId() {
    return id;
  }

  public String getNameOfSpecialty() {
    return nameOfSpecialty;
  }

  public void setNameOfSpecialty(String nameOfSpecialty) {
    this.nameOfSpecialty = nameOfSpecialty;
  }
}
