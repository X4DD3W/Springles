package com.springles.tickets.controllers;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

  AppointmentService appointmentService;

  @Autowired
  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @PostMapping("/form")
  public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {
    appointmentService.save(appointment);
    return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
  }
}
