<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Offres de Navettes</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Liste des Offres de Navettes</h2>
    <table class="table table-bordered">
        <tr>
            <th>Ville Départ</th>
            <th>Ville Arrivée</th>
            <th>Départ</th>
            <th>Arrivée</th>
            <th>Période</th>
            <th>Description</th>
        </tr>
        <c:forEach var="offre" items="${offres}">
            <tr>
                <td>${offre.villeDepart}</td>
                <td>${offre.villeArrivee}</td>
                <td>${offre.heureDepart}</td>
                <td>${offre.heureArrivee}</td>
                <td>${offre.dateDebut} - ${offre.dateFin}</td>
                <td>${offre.description}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>