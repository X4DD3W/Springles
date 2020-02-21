package com.springles.tickets.controllers;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.models.MedicalSpecialty;
import com.springles.tickets.services.AppointmentService;
import com.springles.tickets.utils.IdUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppointmentController {

  private AppointmentService appointmentService;

  @Autowired
  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @GetMapping("/new-appointment")
  public String mainPage(@ModelAttribute(name = "newAppointment") Appointment appointment,
      Model model) {
    List<MedicalSpecialty> specialties = new IdUtil().createActualSpecialties();
    model.addAttribute("specialties", specialties);
    return "index";
  }

  @PostMapping("/new-appointment")
  public String saveAppointment(@ModelAttribute Appointment appointment,Model model) {
    // kiszedem az összes fogorvost
    // megnézem a ticketjeiket, és ha mindnek van olyan ticketje, akkor rácseszett és
    // visszairányítom az indexre, hogy fusson neki mégegyszer

    if (appointmentService.isThisAppointmentAvailable(appointment)) {
      appointmentService.save(appointment);
      String message1 = "Dear "+appointment.getPatientName()+" your appointment was successfully scheduled.";
      String message2 = "Our "+appointment.getSpecialist()+" will see you on the following date: "+appointment.getDate();
      model.addAttribute("message1", message1);
      model.addAttribute("message2", message2);
      return "appointmentSuccessfullyScheduled";
    } else {
      return "redirect:/new-appointment";
    }
  }

  @GetMapping("/success")
  public String registerAppointmentSuccess() {
    return "appointmentRegistrated";
  }
}
