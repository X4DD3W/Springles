package com.springles.tickets.controllers;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.models.Doctor;
import com.springles.tickets.services.AppointmentService;
import com.springles.tickets.services.DoctorService;
import com.springles.tickets.services.MedicalSpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

  private AppointmentService appointmentService;
  private DoctorService doctorService;
  private MedicalSpecialtyService medicalSpecialtyService;

  @Autowired
  public AdminController(AppointmentService appointmentService, DoctorService doctorService, MedicalSpecialtyService medicalSpecialtyService) {
    this.appointmentService = appointmentService;
    this.doctorService = doctorService;
    this.medicalSpecialtyService = medicalSpecialtyService;
  }

  @GetMapping("/unpaired-assignments")
  public String listOfUnpairedAssignments(Model model,
                                          @RequestParam(value = "name", required = false) String name,
                                          @RequestParam(value = "specialist", required = false) String specialty) {
    List<Appointment> appointments = appointmentService.listUnpairedAppointments();
    List<Appointment> filteredAppointments;
    model.addAttribute("doctors", doctorService.findAll());
    model.addAttribute("specialties", medicalSpecialtyService.findall());
    model.addAttribute("link", "/unpaired-assignments");
    model.addAttribute("filterDoctor", false);
    if ((name != null && name.equals("all")) || (specialty != null && specialty.equals("all"))) {
      filteredAppointments = appointments;
    } else if (name != null && specialty != null) {
      filteredAppointments = appointmentService.filteredAppointmentsBySpecialty(appointmentService.filteredAppointmentsByName(appointments, name), specialty);
    } else if (name != null) {
      filteredAppointments = appointmentService.filteredAppointmentsByName(appointments, name);
    } else if (specialty != null) {
      filteredAppointments = appointmentService.filteredAppointmentsBySpecialty(appointments, specialty);
    } else {
      filteredAppointments = appointments;
    }
    model.addAttribute("appointments", filteredAppointments);
    return "appointment";
  }

  @GetMapping("/paired-assignments")
  public String listOfPairedAssignments(Model model,
                                        @RequestParam(value = "name", required = false) String name,
                                        @RequestParam(value = "specialist", required = false) String specialty) {
    List<Appointment> appointments = appointmentService.listPairedAppointments();
    List<Appointment> filteredAppointments;
    model.addAttribute("doctors", doctorService.findAll());
    model.addAttribute("specialties", medicalSpecialtyService.findall());
    model.addAttribute("link", "/paired-assignments");
    model.addAttribute("filterDoctor", true);
    if ((name != null && name.equals("all")) || (specialty != null && specialty.equals("all"))) {
      filteredAppointments = appointments;
    } else if (name != null && specialty != null) {
      filteredAppointments = appointmentService.filteredAppointmentsBySpecialty(appointmentService.filteredAppointmentsByName(appointments, name), specialty);
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
