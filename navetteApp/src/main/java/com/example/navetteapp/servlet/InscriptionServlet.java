package com.example.navetteapp.servlet;

import com.example.navetteapp.dao.UtilisateurDAO;
import com.example.navetteapp.model.Utilisateur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException, ServletException {
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        EntityManager em = emf.createEntityManager();
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(em);

        if (utilisateurDAO.trouverParEmail(email) != null) {
            request.setAttribute("erreur", "Cet email est déjà utilisé.");
            request.getRequestDispatcher("views/inscription.jsp").forward(request, response);
            return;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setEmail(email);
        utilisateur.setPassword(password); // Hashage recommandé

        utilisateurDAO.ajouterUtilisateur(utilisateur);
        response.sendRedirect("login.jsp");
    }
}
