package com.example.navetteapp.servlet;

import com.example.navetteapp.dao.OffreAbonnementDAO;
import com.example.navetteapp.model.OffreAbonnement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/offres")
public class OffreServlet extends HttpServlet {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        OffreAbonnementDAO dao = new OffreAbonnementDAO(em);
        List<OffreAbonnement> offres = dao.getAllOffres();

        request.setAttribute("offres", offres);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/offres.jsp");
        dispatcher.forward(request, response);
    }
}