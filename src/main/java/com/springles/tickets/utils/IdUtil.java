package com.springles.tickets.utils;

import com.springles.tickets.models.MedicalSpecialty;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class IdUtil {

  public String generateDoctorId(int length) {
    return generateRandomString(length);
  }

  private String generateRandomString(int length) {
    Random random = new Random();

    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    StringBuilder returnValue = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      returnValue.append(alphabet.charAt(random.nextInt(alphabet.length() - 1)));
    }

    return new String(returnValue);
  }

  public List<MedicalSpecialty> createActualSpecialties() {
    String[] specialtiesToList = new String[]{
        "fogorvos", "sebész", "urológus", "fazekas", "pszichiáter"
    };
    List<MedicalSpecialty> result = new ArrayList<>();
    for (String s : specialtiesToList) {
      result.add(new MedicalSpecialty(s));
    }
    return result;
  }
}
