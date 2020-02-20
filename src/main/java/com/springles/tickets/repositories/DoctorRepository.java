package com.springles.tickets.repositories;

import com.springles.tickets.models.Appointment;
import com.springles.tickets.models.Doctor;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {


  // boolean isThereAvailableDoctor (Appointment appointment);
}
