package com.springles.tickets.controllers;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.services.AppointmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

  private AppointmentService appointmentService;

  @Autowired
  public AdminController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @GetMapping("/unpaired-appointments")
  public String listOfUnpairedAppointments(Model model,
                                           @RequestParam(value = "name", required = false) String name,
                                           @RequestParam(value = "specialist", required = false) String specialty) {
    List<Appointment> appointments = appointmentService.listUnpairedAppointments();
    List<Appointment> filteredAppointments;
    if (name != null && specialty != null) {
      filteredAppointments = appointmentService.filteredAppointmentsBySpecialty(
              appointmentService.filteredAppointmentsByName(appointments, name), specialty);
    } else if (name != null) {
      filteredAppointments = appointmentService.filteredAppointmentsByName(appointments, name);
    } else if (specialty != null) {
      filteredAppointments = appointmentService
              .filteredAppointmentsBySpecialty(appointments, specialty);
    } else {
      filteredAppointments = appointments;
    }
    model.addAttribute("appointments", filteredAppointments);
    return "appointment";
  }

  @GetMapping("/paired-appointments")
  public String listOfPairedAppointments(Model model,
                                         @RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "specialist", required = false) String specialty) {
    List<Appointment> appointments = appointmentService.listPairedAppointments();
    List<Appointment> filteredAppointments;
    if (name != null && specialty != null) {
      filteredAppointments = appointmentService.filteredAppointmentsBySpecialty(
              appointmentService.filteredAppointmentsByName(appointments, name), specialty);
    } else if (name != null) {
      filteredAppointments = appointmentService.filteredAppointmentsByName(appointments, name);
    } else if (specialty != null) {
      filteredAppointments = appointmentService
              .filteredAppointmentsBySpecialty(appointments, specialty);
    } else {
      filteredAppointments = appointments;
    }
    model.addAttribute("appointments", filteredAppointments);
    return "appointment";
  }


}
