package com.springles.tickets.controllers;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.models.MedicalSpecialty;
import com.springles.tickets.services.AppointmentService;
import com.springles.tickets.utils.IdUtil;
import java.text.ParseException;
import java.util.Date;
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

  @GetMapping("/index")
  public String mainPage(@ModelAttribute(name = "newAppointment") Appointment appointment, Model model) {
    List<MedicalSpecialty> specialties = new IdUtil().createActualSpecialties();
    model.addAttribute("specialties", specialties);
    return "index";
  }

  @PostMapping("/index")
  public String saveAppointment(@ModelAttribute Appointment appointment) throws ParseException {
    appointment.setDateOfSubmission(new Date());
/*
    appointment.setDate(new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").format(appointment.getDate()));
*/

    // kiszedem az összes fogorvost
    // megnézem a ticketjeiket, és ha mindnek van olyan ticketje, akkor rácseszett és
    // visszairányítom az indexre, hogy fusson neki mégegyszer

    if (appointmentService.isThisAppointmentAvailable(appointment)) {
      appointmentService.save(appointment);
      return "redirect:/success";
    } else {
      return "redirect:/index";
    }
  }

  @GetMapping("/success")
  public String registerAppointmentSuccess() {
    return "appointmentRegistrated";
  }
}
