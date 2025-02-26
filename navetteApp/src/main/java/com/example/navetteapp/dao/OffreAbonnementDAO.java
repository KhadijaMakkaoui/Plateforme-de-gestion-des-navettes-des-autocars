package com.example.navetteapp.dao;

import com.example.navetteapp.model.OffreAbonnement;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OffreAbonnementDAO {
    private EntityManager entityManager;

    public OffreAbonnementDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<OffreAbonnement> getAllOffres() {
        return entityManager.createQuery("SELECT o FROM OffreAbonnement o", OffreAbonnement.class).getResultList();
    }
}