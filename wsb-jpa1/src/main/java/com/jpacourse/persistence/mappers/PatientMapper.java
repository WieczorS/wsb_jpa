package com.jpacourse.persistence.mappers;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.dtos.PatientDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper {

    public PatientDTO toDTO(PatientEntity entity) {
        if (entity == null) {
            return null;
        }

        PatientDTO dto = new PatientDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setDateOfBirth(entity.getDateOfBirth());

        return dto;
    }




    public PatientEntity toEntity(PatientDTO dto) {
        if (dto == null) {
            return null;
        }

        PatientEntity entity = new PatientEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        return entity;
    }
}