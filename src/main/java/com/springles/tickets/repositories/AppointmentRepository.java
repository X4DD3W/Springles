package com.springles.tickets.repositories;

import com.springles.tickets.models.Appointment;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

  List<Appointment> findAll();

  @Query(value = "SELECT * FROM appointment WHERE doctor_id = id ORDER BY DATE ", nativeQuery = true)
  List<String> getListOfAppointments(Long id);

}
