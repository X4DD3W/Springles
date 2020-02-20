package com.springles.tickets.controllers;

import com.springles.tickets.services.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DoctorController {

  private DoctorService doctorService;

  public DoctorController(DoctorService doctorService) {
    this.doctorService = doctorService;
  }

  @GetMapping("/doctors")
  public String showListOfDoctors(Model model) {
    model.addAttribute("list_of_doctors", doctorService.findAll());
    return "doctors";
  }

  @GetMapping("/doctor/{id}")
  public String showListOfAppointmentsOfSelectedDoctor(@PathVariable Long id, Model model) {
    model.addAttribute("list_of_appointments", doctorService.getListOfAppointments(id));
    return "doctors_schedule";
  }
}
