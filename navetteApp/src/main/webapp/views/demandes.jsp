<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.example.navetteapp.model.Demande" %>
<%
    List<Demande> demandes = (List<Demande>) request.getAttribute("demandes");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Demandes des utilisateurs</title>
</head>
<body>
<h2>Demandes d'abonnement</h2>
<table border="1">
    <tr>
        <th>Départ</th>
        <th>Arrivée</th>
        <th>Heure Départ</th>
        <th>Heure Arrivée</th>
        <th>Période</th>
        <th>Nombre d'intéressés</th>
    </tr>
    <% for (Demande demande : demandes) { %>
    <tr>
        <td><%= demande.getVilleDepart() %></td>
        <td><%= demande.getVilleArrivee() %></td>
        <td><%= demande.getHeureDepart() %></td>
        <td><%= demande.getHeureArrivee() %></td>
        <td><%= demande.getDateDebut() %> - <%= demande.getDateFin() %></td>
        <td><%= demande.getNombreInteresses() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
