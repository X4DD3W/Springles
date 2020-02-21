package com.springles.tickets.models;

import com.springles.tickets.utils.IdUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Doctor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String doctorId;

  private String introduction;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor", fetch = FetchType.LAZY)
  private List<Appointment> listOfAppointments = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor", fetch = FetchType.LAZY)
  private List<MedicalSpecialty> listOfMedicalSpecialties = new ArrayList<>();

  public Doctor() {
  }

  public Doctor(String name, String introduction) {
    this.name = name;
    this.introduction = introduction;
    this.doctorId = new IdUtil().generateDoctorId(20);
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Appointment> getListOfAppointments() {
    return listOfAppointments;
  }

  public List<MedicalSpecialty> getListOfMedicalSpecialties() {
    return listOfMedicalSpecialties;
  }

  public String getDoctorId() {
    return doctorId;
  }

  public String getIntroduction() {
    return introduction;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDoctorId(String doctorId) {
    this.doctorId = doctorId;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public void setListOfAppointments(List<Appointment> listOfAppointments) {
    this.listOfAppointments = listOfAppointments;
  }

  public void setListOfMedicalSpecialties(List<MedicalSpecialty> listOfMedicalSpecialties) {
    this.listOfMedicalSpecialties = listOfMedicalSpecialties;
  }

  public void addSpecialty(MedicalSpecialty specialty){
    this.listOfMedicalSpecialties.add(specialty);
  }
}
