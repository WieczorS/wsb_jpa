package com.jpacourse.persistence.service;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientEntity> findAll() {
        return patientRepository.findAll();
    }

    public PatientEntity findById(Long id) {
        return patientRepository.findById(id);
    }

    public void save(PatientEntity patient) {
        patientRepository.save(patient);
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}
