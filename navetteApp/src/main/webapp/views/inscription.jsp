<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
<h2>Créer un compte</h2>
<form action="inscription" method="post">
    <label>Nom:</label>
    <input type="text" name="nom" required /><br>

    <label>Email:</label>
    <input type="email" name="email" required /><br>

    <label>Mot de passe:</label>
    <input type="password" name="password" required /><br>

    <button type="submit">S'inscrire</button>
</form>
<p>Déjà un compte ? <a href="login.jsp">Se connecter</a></p>
</body>
</html>
