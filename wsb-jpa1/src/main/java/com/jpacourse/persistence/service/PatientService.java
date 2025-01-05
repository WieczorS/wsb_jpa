package com.jpacourse.persistence.service;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dtos.PatientDTO;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.mappers.PatientMapper;
import com.jpacourse.persistence.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientMapper patientMapper;

    @Transactional
    public void deletePatient(Long patientId) {
        PatientEntity patient = patientDao.findById(patientId);
        if (patient != null) {
            patientDao.delete(patient);
        }
    }

    @Transactional
    public PatientDTO getPatientById(Long id) {
        PatientEntity patient = patientDao.findById(id);
        if (patient == null) {
            throw new EntityNotFoundException("Patient not found");
        }
        return patientMapper.toDTO(patient);
    }

    @Transactional
    public void addVisit(Long patientId, VisitEntity visit) {
        patientDao.addVisit(patientId, visit);
    }
}

