package com.springles.tickets.controllers;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppointmentController {

  AppointmentService appointmentService;

  @Autowired
  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @PostMapping("/form")
  public String saveAppointment(@ModelAttribute Appointment appointment) {
    appointmentService.save(appointment);
    return "redirect:/somewhereovertherainbow";
  }
}
