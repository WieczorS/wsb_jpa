package com.jpacourse.persistance.dao;

@SpringBootTest
@Transactional
class PatientServiceTest {

   @Autowired
   private PatientService patientService;

   @Autowired
   private PatientDao patientDao;

   @Autowired
   private VisitDao visitDao;

   @Test
   void testDeletePatient() {
      Long patientId = 1L;
      patientService.deletePatient(patientId);

      assertNull(patientDao.findById(patientId));
   }

   @Test
   void testGetPatientById() {
      PatientTO patientTO = patientService.getPatientById(1L);

      assertNotNull(patientTO);
      assertEquals("John", patientTO.getFirstName());
      assertEquals(LocalDate.of(1990, 1, 1), patientTO.getDateOfBirth());
   }

   @Test
   void testAddVisit() {
      Long patientId = 1L;
      VisitEntity visit = new VisitEntity();
      visit.setVisitDate(LocalDateTime.now());
      visit.setDoctor(new DoctorEntity("Adam", "Nowak"));

      patientService.addVisit(patientId, visit);

      PatientEntity patient = patientDao.findById(patientId);
      assertNotNull(patient);
      assertEquals(1, patient.getVisits().size());
   }
}
