package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PatientServiceTest {

   @Mock
   private PatientRepository patientRepository;

   @InjectMocks
   private PatientService patientService;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);
   }

   @Test
   void testDeletePatientCascadingVisits() {
      Long patientId = 1L;
      PatientEntity patient = new PatientEntity();
      patient.setId(patientId);

      when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));

      patientService.deleteById(patientId);

      verify(patientRepository, times(1)).deleteById(patientId);
      
   }

   @Test
   void testFindPatientById() {
      Long patientId = 1L;
      PatientEntity patient = new PatientEntity();
      patient.setId(patientId);
      

      when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));

      Optional<PatientEntity> foundPatient = patientService.findById(patientId);

      assertTrue(foundPatient.isPresent());
      assertEquals(patientId, foundPatient.get().getId());
   }
}