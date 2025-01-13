package com.jpacourse.mapper;

import com.jpacourse.persistence.dtos.PatientDTO;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper {

    public static PatientDTO toDTO(PatientEntity patient) {
        if (patient == null) {
            return null;
        }

        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setDateOfBirth(patient.getDateOfBirth());

        if (patient.getVisits() != null) {
            List<PatientDTO.VisitDTO> visitDTOS = patient.getVisits().stream()
                    .map(PatientMapper::mapVisitToDTO)
                    .collect(Collectors.toList());
            patientDTO.setVisits(visitDTOS);
        }
        return patientDTO;
    }

    private static PatientDTO.VisitDTO mapVisitToDTO(VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }

        PatientDTO.VisitDTO visitDTO = new PatientDTO.VisitDTO();
        visitDTO.setTime(visitEntity.getVisitDate());
        visitDTO.setDoctorFirstName(visitEntity.getDoctor().getFirstName());
        visitDTO.setDoctorLastName(visitEntity.getDoctor().getLastName());
        visitDTO.setTreatmentTypes(null);

        return visitDTO;
    }

    public static PatientEntity toEntity(PatientDTO patientDTO) {
        PatientEntity entity = new PatientEntity();
        entity.setId(patientDTO.getId());
        entity.setFirstName(patientDTO.getFirstName());
        entity.setLastName(patientDTO.getLastName());
        entity.setDateOfBirth(patientDTO.getDateOfBirth());
        if (patientDTO.getVisits() != null) {
            List<VisitEntity> visitEntities = patientDTO.getVisits().stream()
                    .map(PatientMapper::mapVisitToEntity)
                    .collect(Collectors.toList());
            entity.setVisits(visitEntities);
        }        return entity;
    }

    private static VisitEntity mapVisitToEntity(PatientDTO.VisitDTO visitDTO) {
        if (visitDTO == null) {
            return null;
        }

        VisitEntity visitEntity = new VisitEntity();

        visitEntity.setVisitDate(visitDTO.getTime());
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setFirstName(visitDTO.getDoctorFirstName());
        doctorEntity.setLastName(visitDTO.getDoctorLastName());
        visitEntity.setDoctor(doctorEntity);

        return visitEntity;
    }

}
