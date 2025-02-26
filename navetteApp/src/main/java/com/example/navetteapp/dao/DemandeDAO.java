package com.example.navetteapp.dao;
import com.example.navetteapp.model.Demande;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DemandeDAO {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("navette_persistence");

    public void ajouterDemande(Demande demande) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(demande);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Demande getDemandeExistante(String villeDepart, String villeArrivee, LocalTime heureDepart, LocalTime heureArrivee, LocalDate dateDebut, LocalDate dateFin) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Demande demande = null;

        try {
            demande = entityManager.createQuery(
                            "SELECT d FROM Demande d WHERE d.villeDepart = :villeDepart AND d.villeArrivee = :villeArrivee " +
                                    "AND d.heureDepart = :heureDepart AND d.heureArrivee = :heureArrivee " +
                                    "AND d.dateDebut = :dateDebut AND d.dateFin = :dateFin", Demande.class)
                    .setParameter("villeDepart", villeDepart)
                    .setParameter("villeArrivee", villeArrivee)
                    .setParameter("heureDepart", heureDepart)
                    .setParameter("heureArrivee", heureArrivee)
                    .setParameter("dateDebut", dateDebut)
                    .setParameter("dateFin", dateFin)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

        return demande;
    }

    public void incrementerInteresses(int demandeId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Demande demande = entityManager.find(Demande.class, demandeId);
        if (demande != null) {
            demande.setNombreInteresses(demande.getNombreInteresses() + 1);
            entityManager.merge(demande);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Demande> getAllDemandes() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Demande> demandes = entityManager.createQuery("SELECT d FROM Demande d", Demande.class).getResultList();
        entityManager.close();
        return demandes;
    }
}
