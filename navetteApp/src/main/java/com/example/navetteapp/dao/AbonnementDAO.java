package com.example.navetteapp.dao;

import com.example.navetteapp.model.Abonnement;
import com.example.navetteapp.model.OffreAbonnement;
import com.example.navetteapp.model.Utilisateur;
import jakarta.persistence.*;

public class AbonnementDAO {
    private EntityManager entityManager;

    public AbonnementDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void ajouterAbonnement(Abonnement abonnement) {
        entityManager.getTransaction().begin();
        entityManager.persist(abonnement);
        entityManager.getTransaction().commit();
    }

    public boolean estDejaAbonne(Utilisateur utilisateur, OffreAbonnement offre) {
        Long count = entityManager.createQuery("SELECT COUNT(a) FROM Abonnement a WHERE a.utilisateur = :utilisateur AND a.offre = :offre", Long.class)
                .setParameter("utilisateur", utilisateur)
                .setParameter("offre", offre)
                .getSingleResult();
        return count > 0;
    }
}
