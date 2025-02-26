package com.example.navetteapp.servlet;
import com.example.navetteapp.dao.AbonnementDAO;
import com.example.navetteapp.model.Abonnement;
import com.example.navetteapp.model.OffreAbonnement;
import com.example.navetteapp.model.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/abonner")
public class AbonnementServlet extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
        if (utilisateur == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Long offreId = Long.parseLong(request.getParameter("offreId"));
        EntityManager em = emf.createEntityManager();
        OffreAbonnement offre = em.find(OffreAbonnement.class, offreId);
        AbonnementDAO abonnementDAO = new AbonnementDAO(em);

        if (abonnementDAO.estDejaAbonne(utilisateur, offre)) {
            request.setAttribute("erreur", "Vous êtes déjà abonné à cette offre.");
            request.getRequestDispatcher("views/offres.jsp").forward(request, response);
            return;
        }

        Abonnement abonnement = new Abonnement();
        abonnement.setUtilisateur(utilisateur);
        abonnement.setOffre(offre);
        abonnementDAO.ajouterAbonnement(abonnement);

        response.sendRedirect("offres.jsp");
    }
}
