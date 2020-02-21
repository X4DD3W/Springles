package com.springles.tickets.controllers;

import com.springles.tickets.models.ApplicationUser;
import com.springles.tickets.repositories.ApplicationUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class UserController {

  private ApplicationUserRepository applicationUserRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserController(ApplicationUserRepository applicationUserRepository,
      BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.applicationUserRepository = applicationUserRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @GetMapping("/")
  public String showRegistrationForm(@ModelAttribute(value = "new_user") ApplicationUser newUser,
      Model model) {
    model.addAttribute("new_user", newUser);
    return "new_user_form";
  }

  @PostMapping("/")
  public String signUp(@ModelAttribute(value = "new_user") ApplicationUser newUser) {
    newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
    applicationUserRepository.save(newUser);
    return "redirect:/register/welcome";
  }

  @GetMapping("/welcome")
  public String welcomePage() {
    return "welcome";
  }

}
