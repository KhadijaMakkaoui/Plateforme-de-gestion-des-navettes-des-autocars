<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, models.OffreAbonnement" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="models.Utilisateur" %>
<%
    HttpSession sessionObj = request.getSession(false);
    Utilisateur utilisateur = (sessionObj != null) ? (Utilisateur) sessionObj.getAttribute("utilisateur") : null;
%>
<!DOCTYPE html>
<html>
<head>
    <title>Accueil</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<header>
    <h1>Bienvenue sur la plateforme de gestion des navettes</h1>
    <nav>
            <% if (utilisateur != null) { %>
        <a href="offres.jsp">Voir les offres</a>
        <a href="demandes.jsp">Voir les
