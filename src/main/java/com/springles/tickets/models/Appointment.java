package com.springles.tickets.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.*;

@Entity
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String patientName;

  private String phoneNumber;

  private String email;

  private String specialist;

  private String description;

  @ManyToOne
  private Doctor doctor;

  private String date;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dateOfSubmission;

  public Appointment() {
  }

  public Appointment(String patientName, String phoneNumber, String email, String specialist,
      String description, String date, Date dateOfSubmission) {
    this.patientName = patientName;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.specialist = specialist;
    this.description = description;
    this.date = date;
    this.dateOfSubmission = new Date();
  }

  public Long getId() {
    return id;
  }

  public String getPatientName() {
    return patientName;
  }

  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSpecialist() {
    return specialist;
  }

  public void setSpecialist(String specialist) {
    this.specialist = specialist;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Date getDateOfSubmission() {
    return dateOfSubmission;
  }

  public void setDateOfSubmission(Date dateOfSubmission) {
    this.dateOfSubmission = dateOfSubmission;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }
}
