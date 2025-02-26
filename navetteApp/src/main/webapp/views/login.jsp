<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Connexion</title>
</head>
<body>
<h2>Connexion</h2>
<form action="login" method="post">
    <label>Email:</label>
    <input type="email" name="email" required /><br>

    <label>Mot de passe:</label>
    <input type="password" name="password" required /><br>

    <button type="submit">Se connecter</button>
</form>
<p>Pas encore inscrit ? <a href="inscription.jsp">Créer un compte</a></p>
</body>
</html>
