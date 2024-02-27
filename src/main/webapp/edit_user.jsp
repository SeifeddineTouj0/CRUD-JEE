<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier un utilisateur</title>
</head>
<body>
    <h1>Modifier un utilisateur</h1>
    <form action="user?action=update" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <label for="username">Nom d'utilisateur:</label>
        <input type="text" id="username" name="username" value="${user.username}" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${user.email}" required><br><br>
        <input type="submit" value="Modifier">
    </form>
    <a href="index.jsp">Retour à la liste des utilisateurs</a>
</body>
</html>
