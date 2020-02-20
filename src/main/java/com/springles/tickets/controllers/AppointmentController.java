package com.springles.tickets.controllers;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class AppointmentController {

  private AppointmentService appointmentService;

  @Autowired
  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @PostMapping("/form")
  public String saveAppointment(@ModelAttribute Appointment appointment) {
    // ha nincs viszlátka
    if (appointmentService.isThisAppointmentAvailable(appointment)) {
      appointmentService.save(appointment);
    }
    return "appointmentRegistrated";
  }
}
