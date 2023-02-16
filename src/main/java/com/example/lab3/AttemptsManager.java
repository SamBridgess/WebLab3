package com.example.lab3;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Singleton
@Named("attempts")
@Transactional
public class AttemptsManager {
    @PersistenceContext
    private EntityManager em;

    List<PointAttempt> attempts;

    @PostConstruct
    public void init() {
        attempts = new LinkedList<>(em.createQuery("SELECT a FROM com.example.lab3.PointAttempt a").getResultList());
    }

    public void addAttempt(PointAttempt attempt) {
        attempts.add(attempt);
        em.persist(attempt);
    }

    public void clear() {
        em.createQuery("delete com.example.lab3.PointAttempt a").executeUpdate();
        attempts.clear();
    }

    public List<PointAttempt> getAttempts() {
        attempts.sort((x, y) -> Long.compare(y.getAttemptTime(), x.getAttemptTime()));
        return attempts;
    }
}
