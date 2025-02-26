<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nouvelle Demande</title>
</head>
<body>
<h2>Soumettre une demande de navette</h2>
<form action="ajouterDemande" method="post">
    <label>Ville de départ :</label>
    <input type="text" name="villeDepart" required /><br>

    <label>Ville d'arrivée :</label>
    <input type="text" name="villeArrivee" required /><br>

    <label>Heure de départ :</label>
    <input type="time" name="heureDepart" required /><br>

    <label>Heure d'arrivée :</label>
    <input type="time" name="heureArrivee" required /><br>

    <label>Date de début :</label>
    <input type="date" name="dateDebut" required /><br>

    <label>Date de fin :</label>
    <input type="date" name="dateFin" required /><br>

    <button type="submit">Soumettre la demande</button>
</form>
</body>
</html>
