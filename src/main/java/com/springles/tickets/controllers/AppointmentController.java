package com.springles.tickets.controllers;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.services.AppointmentService;
import com.springles.tickets.utils.IdUtil;
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
  public String addNewAppointment(@ModelAttribute(name = "newAppointment") Appointment appointment,
      Model model) {
    model.addAttribute("specialties", new IdUtil().createActualSpecialties());
    return "index";
  }

  @PostMapping("/new-appointment")
  public String saveAppointment(@ModelAttribute Appointment appointment) {
    // 1. Kiszedem az összes pl. "fogorvost" és összevetem a userinputot az elérhető orvosokkal,
    // 2. és ha egyiket sem lehet hozzárendelni a kért időpont-specialist kombinációhoz:
    // 3. visszairányítom az indexre, hogy fusson neki mégegyszer. Béta:
    if (appointmentService.isThisAppointmentAvailable(appointment)) {
      appointmentService.save(appointment);
      return "redirect:/success";
    } else {
      // üresen érkeznek a fieldek, @RequestParammal menjenek majd a korábban megadott adatok!
      return "redirect:/new-appointment";
    }
  }

  @GetMapping("/success")
  public String successfulSavingOfAppointment() {
    return "summa";
  }
}
