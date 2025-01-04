package com.jpacourse.persistence.repository;

import com.jpacourse.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    @Query("SELECT p FROM PatientEntity p WHERE p.lastName = :lastName")
    List<PatientEntity> findByLastName(@Param("lastName") String lastName);

    @Query("SELECT p FROM PatientEntity p WHERE p.dateOfBirth = :dateOfBirth")
    List<PatientEntity> findByDateOfBirth(@Param("dateOfBirth") LocalDate dateOfBirth);
}
