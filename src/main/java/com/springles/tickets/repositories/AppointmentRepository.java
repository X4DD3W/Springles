package com.springles.tickets.repositories;

import com.springles.tickets.models.Appointment;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

  @Query(value = "select * from appointment where doctor_id = id order by date ", nativeQuery = true)
  List<String> getListOfAppointments(Long id);
}
