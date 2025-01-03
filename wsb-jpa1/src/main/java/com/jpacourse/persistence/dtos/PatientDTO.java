package com.jpacourse.persistence.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PatientDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private List<VisitDTO> visits;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<VisitDTO> getVisits() {
        return visits;
    }

    public void setVisits(List<VisitDTO> visits) {
        this.visits = visits;
    }

    // Nested VisitDTO class
    public static class VisitDTO {
        private LocalDateTime time;
        private String doctorFirstName;
        private String doctorLastName;
        private List<String> treatmentTypes;

        // Getters and Setters

        public LocalDateTime getTime() {
            return time;
        }

        public void setTime(LocalDateTime time) {
            this.time = time;
        }

        public String getDoctorFirstName() {
            return doctorFirstName;
        }

        public void setDoctorFirstName(String doctorFirstName) {
            this.doctorFirstName = doctorFirstName;
        }

        public String getDoctorLastName() {
            return doctorLastName;
        }

        public void setDoctorLastName(String doctorLastName) {
            this.doctorLastName = doctorLastName;
        }

        public List<String> getTreatmentTypes() {
            return treatmentTypes;
        }

        public void setTreatmentTypes(List<String> treatmentTypes) {
            this.treatmentTypes = treatmentTypes;
        }
    }
}
