package com.example.navetteapp.servlet;


import com.example.navetteapp.dao.DemandeDAO;
import com.example.navetteapp.model.Demande;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/ajouterDemande")
public class AjouterDemandeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String villeDepart = request.getParameter("villeDepart");
        String villeArrivee = request.getParameter("villeArrivee");
        LocalTime heureDepart = LocalTime.parse(request.getParameter("heureDepart"));
        LocalTime heureArrivee = LocalTime.parse(request.getParameter("heureArrivee"));
        LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebut"));
        LocalDate dateFin = LocalDate.parse(request.getParameter("dateFin"));

        DemandeDAO demandeDAO = new DemandeDAO();
        Demande demandeExistante = demandeDAO.getDemandeExistante(villeDepart, villeArrivee, heureDepart, heureArrivee, dateDebut, dateFin);

        if (demandeExistante != null) {
            demandeDAO.incrementerInteresses(demandeExistante.getId());
        } else {
            Demande nouvelleDemande = new Demande(villeDepart, villeArrivee, heureDepart, heureArrivee, dateDebut, dateFin, 1);
            demandeDAO.ajouterDemande(nouvelleDemande);
        }

        response.sendRedirect("demandes.jsp");
    }
}

