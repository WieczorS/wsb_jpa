-- Insert data into ADDRESS table
INSERT INTO ADDRESS (id, address_line1, address_line2, city, postal_code) VALUES (1, 'Ul. Główna 1', 'Mieszkanie 4', 'Warszawa', '00-001');
INSERT INTO ADDRESS (id, address_line1, address_line2, city, postal_code) VALUES (2, 'Ul. Długa 5', NULL, 'Kraków', '30-002');

-- Insert data into DOCTOR table
INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, doctor_number, specialization) VALUES (1, 'Jan', 'Kowalski', '555123456', 'jan.kowalski@example.com', 'D123', 'KARDIOLOGIA');
INSERT INTO DOCTOR (id, first_name, last_name, telephone_number, email, doctor_number, specialization) VALUES (2, 'Anna', 'Nowak', '555567890', 'anna.nowak@example.com', 'D456', 'NEUROLOGIA');

-- Insert data into PATIENT table
INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth) VALUES (1, 'Alicja', 'Wiśniewska', '555876543', 'alicja.wisniewska@example.com', 'P123', '1980-01-01');
INSERT INTO PATIENT (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth) VALUES (2, 'Piotr', 'Wójcik', '555432109', 'piotr.wojcik@example.com', 'P456', '1990-02-02');

-- Insert data into VISIT table
INSERT INTO VISIT (id, description, time, doctor_id, patient_id) VALUES (1, 'Wizyta kontrolna', '2023-01-01T10:00:00', 1, 1);
INSERT INTO VISIT (id, description, time, doctor_id, patient_id) VALUES (2, 'Wizyta kontrolna', '2023-02-01T11:00:00', 2, 2);

-- Insert data into MEDICAL_TREATMENT table
INSERT INTO MEDICAL_TREATMENT (id, treatment_name, doctor_id) VALUES (1, 'Fizjoterapia', 1);
INSERT INTO MEDICAL_TREATMENT (id, treatment_name, doctor_id) VALUES (2, 'Chemoterapia', 2);

-- Insert data into doctor_address join table
INSERT INTO doctor_address (doctor_id, address_id) VALUES (1, 1);
INSERT INTO doctor_address (doctor_id, address_id) VALUES (2, 2);

-- Insert data into patient_address join table
INSERT INTO patient_address (patient_id, address_id) VALUES (1, 1);
INSERT INTO patient_address (patient_id, address_id) VALUES (2, 2);