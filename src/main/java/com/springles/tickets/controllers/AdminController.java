package com.springles.tickets.controllers;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.models.Doctor;
import com.springles.tickets.models.MedicalSpecialty;
import com.springles.tickets.services.AppointmentService;
import com.springles.tickets.services.DoctorService;
import com.springles.tickets.services.MedicalSpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

  private AppointmentService appointmentService;
  private DoctorService doctorService;
  private MedicalSpecialtyService medicalSpecialtyService;

  @Autowired
  public AdminController(AppointmentService appointmentService, DoctorService doctorService,
      MedicalSpecialtyService medicalSpecialtyService) {
    this.appointmentService = appointmentService;
    this.doctorService = doctorService;
    this.medicalSpecialtyService = medicalSpecialtyService;
  }

  @GetMapping("/appointments")
  public String listAllAppointments(Model model,
      @RequestParam(value = "name", required = false) String name,
      @RequestParam(value = "specialist", required = false) String specialty) {
    List<Appointment> appointments = appointmentService.listAll();
    List<Appointment> filteredAppointments;
    model.addAttribute("doctors", doctorService.findAll());
    model.addAttribute("specialties", medicalSpecialtyService.findall());
    model.addAttribute("link", "/appointments");
    if ((name != null && name.equals("all")) || (specialty != null && specialty.equals("all"))) {
      filteredAppointments = appointments;
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

  @GetMapping("/unpaired-appointments")
  public String listOfUnpairedAppointments(Model model,
      @RequestParam(value = "name", required = false) String name,
      @RequestParam(value = "specialist", required = false) String specialty) {
    List<Appointment> appointments = appointmentService.listUnpairedAppointments();
    List<Appointment> filteredAppointments;
    model.addAttribute("doctors", doctorService.findAll());
    model.addAttribute("specialties", medicalSpecialtyService.findall());
    model.addAttribute("link", "/unpaired-appointments");
    if ((name != null && name.equals("all")) || (specialty != null && specialty.equals("all"))) {
      filteredAppointments = appointments;
    } else if (name != null && specialty != null) {
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
    model.addAttribute("doctors", doctorService.findAll());
    model.addAttribute("specialties", medicalSpecialtyService.findall());
    model.addAttribute("link", "/paired-appointments");
    if ((name != null && name.equals("all")) || (specialty != null && specialty.equals("all"))) {
      filteredAppointments = appointments;
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

  @GetMapping("/delete")
  public String deleteAppointment(@RequestParam("id") Long id) {
    appointmentService.deleteAppointment(id);
    return "redirect:/appointments";
  }

  @GetMapping("/edit")
  public String editAppointment(@RequestParam("id") Long id,
      @RequestParam(value = "error", required = false) String error,
      @ModelAttribute("appointment") Appointment appointment, Model model) {
    model.addAttribute("original", appointmentService.findById(id));
    model.addAttribute("doctors", doctorService.findAll());
    model.addAttribute("specialties", medicalSpecialtyService.findall());
    if (error != null && error.equals("true")) {
      model.addAttribute("error", error);
    } else {
      model.addAttribute("error", "false");
    }
    return "editAppointment";
  }

  @PostMapping("/edit")
  public String editAppointment(@ModelAttribute("appointment") Appointment appointment,
      @RequestParam("id") Long id, Model model) {
    if (!appointmentService
        .isDoctorHasTheSpecialty(appointment.getSpecialist(), appointment.getDoctor())) {
      return "redirect:/edit?id=" + appointment.getId() + "&error=true";
    } else {
      appointmentService.save(appointment);
      return "redirect:/appointments";
    }
  }

  @GetMapping("/docs")
  public String listAllDoctors(Model model){
    model.addAttribute("doctors", doctorService.findAll());
    return "doctors";
  }

  @GetMapping("/doc")
  public String docDetails(@RequestParam(value = "id", required = false) Long id, Model model){
    if (id == null){
      return "redirect:/docs";
    }else{
      model.addAttribute("doc", doctorService.findById(id));
      return "doctor";
    }
  }

  @GetMapping("/specialty")
  public String addSpecialty(@RequestParam("id") Long id, @ModelAttribute ("specialty")MedicalSpecialty specialty, Model model){
    model.addAttribute("doc", doctorService.findById(id));
    return "addSpecialty";
  }

  @PostMapping("/specialty")
  public String addSpecialty(@ModelAttribute ("specialty") MedicalSpecialty specialty, @RequestParam("id") Long id){
    specialty.setDoctor(doctorService.findById(id));
    doctorService.findById(id).addSpecialty(medicalSpecialtyService.save(specialty));
    return "redirect:/doc?id=" + id;
  }

  @GetMapping("/delete-doc")
  public String deleteDoc(@RequestParam("id") Long id){
    doctorService.deleteDoctor(id);
    return "redirect:/docs";
  }

  @GetMapping("/saveNewDoctor")
  public String saveDoctor(@ModelAttribute("doctor")Doctor doctor){
    return "newDoctor";
  }

  @PostMapping("/saveNewDoctor")
  public String saveDoc(@ModelAttribute("doctor") Doctor doctor){
    doctorService.save(doctor);
    return "redirect:/docs";
  }
}
