package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class VisitDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(VisitEntity visit) {
        entityManager.persist(visit);
    }

    public VisitEntity findById(Long id) {
        return entityManager.find(VisitEntity.class, id);
    }
}