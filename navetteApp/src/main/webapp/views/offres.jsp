<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.example.navetteapp.model.OffreAbonnement" %>
<%
    List<OffreAbonnement> offres = (List<OffreAbonnement>) request.getAttribute("offres");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Offres de navettes</title>
</head>
<body>
<h2>Liste des offres</h2>
<table border="1">
    <tr>
        <th>Départ</th>
        <th>Arrivée</th>
        <th>Heure Départ</th>
        <th>Heure Arrivée</th>
        <th>Période</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
    <% for (OffreAbonnement offre : offres) { %>
    <tr>
        <td><%= offre.getVilleDepart() %></td>
        <td><%= offre.getVilleArrivee() %></td>
        <td><%= offre.getHeureDepart() %></td>
        <td><%= offre.getHeureArrivee() %></td>
        <td><%= offre.getDateDebut() %> - <%= offre.getDateFin() %></td>
        <td><%= offre.getDescription() %></td>
        <td>
            <form action="abonner" method="post">
                <input type="hidden" name="offreId" value="<%= offre.getId() %>" />
                <button type="submit">S'abonner</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
