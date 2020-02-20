package com.springles.tickets.repositories;

import com.springles.tickets.models.Doctor;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

  @Query(value = "select name from doctor order by name", nativeQuery = true)
  List<String> getListOfDoctorNames();
}
