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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        EntityManager em = emf.createEntityManager();
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(em);
        Utilisateur utilisateur = utilisateurDAO.trouverParEmail(email);

        if (utilisateur != null && utilisateur.getPassword().equals(password)) {
            request.getSession().setAttribute("utilisateur", utilisateur);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("erreur", "Email ou mot de passe incorrect.");
            request.getRequestDispatcher("views/login.jsp").forward(request, response);
        }
    }
}
