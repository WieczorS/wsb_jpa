package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PatientDao {

    @PersistenceContext
    private EntityManager entityManager;

    public PatientEntity findById(Long id) {
        return entityManager.find(PatientEntity.class, id);
    }

    public void save(PatientEntity patient) {
        entityManager.persist(patient);
    }

    public void delete(PatientEntity patient) {
        entityManager.remove(patient);
    }

    public void update(PatientEntity patient) {
        entityManager.merge(patient);
    }

    public void addVisit(Long patientId, VisitEntity visit) {
        PatientEntity patient = findById(patientId);
        if (patient != null) {
            patient.getVisits().add(visit);
            visit.setPatient(patient);
            entityManager.persist(visit); // Zapis wizyty
        }
    }
}
