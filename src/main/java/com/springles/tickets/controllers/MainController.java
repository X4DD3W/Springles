package com.springles.tickets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/welcome")
  public String mainPage() {
    return "hi, I'm Johny Knoxville";
  }
}
