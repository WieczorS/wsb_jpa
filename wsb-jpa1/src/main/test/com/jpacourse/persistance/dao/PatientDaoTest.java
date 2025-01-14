@SpringBootTest
@Transactional
class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private VisitDao visitDao;

    @Test
    void testAddVisit() {
        Long patientId = 1L;

        PatientEntity patient = patientDao.findById(patientId);
        VisitEntity visit = new VisitEntity();
        visit.setVisitDate(LocalDateTime.now());

        patientDao.addVisit(patientId, visit);

        PatientEntity updatedPatient = patientDao.findById(patientId);
        assertNotNull(updatedPatient);
        assertEquals(1, updatedPatient.getVisits().size());
    }

    @Test
    void testDeletePatient() {
        Long patientId = 1L;

        PatientEntity patient = patientDao.findById(patientId);
        patientDao.delete(patient);

        PatientEntity deletedPatient = patientDao.findById(patientId);
        assertNull(deletedPatient);
    }
}
