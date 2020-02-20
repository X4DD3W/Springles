package com.springles.tickets.repositories;

import com.springles.tickets.models.Appointment;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

  List<Appointment> findAll();

}
