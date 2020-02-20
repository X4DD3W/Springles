package com.springles.tickets.repositories;

import com.springles.tickets.models.MedicalSpecialty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalSpecialtyRepository extends CrudRepository<MedicalSpecialty,Long> {
}
