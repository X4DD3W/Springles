package com.springles.tickets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

  @GetMapping("/welcome")
  public String showListOfDoctors(Model model) {
    return "landingPage";
  }
}
