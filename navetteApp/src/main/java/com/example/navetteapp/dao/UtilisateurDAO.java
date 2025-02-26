package com.example.navetteapp.dao;

import com.example.navetteapp.model.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class UtilisateurDAO {
    private EntityManager entityManager;

    public UtilisateurDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        entityManager.getTransaction().begin();
        entityManager.persist(utilisateur);
        entityManager.getTransaction().commit();
    }

    public Utilisateur trouverParEmail(String email) {
        try {
            return entityManager.createQuery("SELECT u FROM Utilisateur u WHERE u.email = :email", Utilisateur.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}