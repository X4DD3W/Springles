package com.springles.tickets.controllers;

import com.springles.tickets.models.Doctor;
import com.springles.tickets.services.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
  public String showListOfAppointmentsOfSelectedDoctor(@PathVariable Long id,
                                                       Model model) {
    model.addAttribute("list_of_appointments", doctorService.getListOfAppointments(id));
    return "doctors_schedule";
  }

  @GetMapping("/manage-doctors")
  public String showListOfDoctorsToAddEditOrDelete(Model model){
    model.addAttribute("list_of_doctors", doctorService.findAll());
    return "manage_doctors";
  }

  @DeleteMapping("/manage-doctors/delete/{id}")
  public String deleteDoctorFromDatabase(@PathVariable Long id,
                                         Model model){
    doctorService.deleteDoctor(id);
    model.addAttribute("list_of_doctors", doctorService.findAll());
    return "redirect:/manage-doctors";
  }

  @GetMapping("/add-doctor")
  public String showAddDoctorForm(@ModelAttribute(value = "new_doctor") Doctor newDoctor,
                                  Model model){
    model.addAttribute("new_doctor", newDoctor);
    return "new_doctor_form";
  }

  @PostMapping("/add-doctor")
  public String addNewDoctorToTheDatabase(@ModelAttribute(value = "new_doctor") Doctor newDoctor,
                                          Model model){
    doctorService.save(newDoctor);
    model.addAttribute("list_of_doctors", doctorService.findAll());
    return "redirect:/manage-doctors";
  }

  @GetMapping("/edit/doctor/{id}")
  public String showEditDoctorForm(@PathVariable Long id,
                                   @ModelAttribute(value = "edited_doctor") Doctor editedDoctor,
                                   Model model){
    model.addAttribute("edited_doctor", doctorService.findById(id));
    return "edit_doctor_form";
  }

  @PutMapping("/edit-doctor/{id}")
  public String editDoctorDetails(@PathVariable Long id,
                                  @ModelAttribute(value = "edited_doctor") Doctor editedDoctor,
                                  Model model){
    editedDoctor.setId(id);
    doctorService.save(editedDoctor);
    return "redirect:/manage-doctors";
  }
}
