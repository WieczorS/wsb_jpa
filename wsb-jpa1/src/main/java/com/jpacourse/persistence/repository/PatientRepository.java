package com.jpacourse.persistence.repository;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PatientRepository {

    public void save(PatientEntity patient) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(patient);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public PatientEntity findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(PatientEntity.class, id);
        }
    }

    public List<PatientEntity> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from PatientEntity", PatientEntity.class).list();
        }
    }

    public void deleteById(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            PatientEntity patient = session.get(PatientEntity.class, id);
            if (patient != null) {
                session.delete(patient);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<PatientEntity> findByLastName(String lastName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from PatientEntity where lastName = :lastName", PatientEntity.class)
                    .setParameter("lastName", lastName)
                    .list();
        }
    }

    public List<PatientEntity> findByDateOfBirth(LocalDate dateOfBirth) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from PatientEntity where dateOfBirth = :dateOfBirth", PatientEntity.class)
                    .setParameter("dateOfBirth", dateOfBirth)
                    .list();
        }
    }
}