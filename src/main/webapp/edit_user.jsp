<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier un utilisateur</title>
</head>
<body>
    <h1>Modifier un utilisateur</h1>
    
    <%-- Define the UserBean using <jsp:useBean> --%>
    <jsp:useBean id="user" class="User.UserBean" scope="request"/>
    
    <%-- Set properties of UserBean using <jsp:setProperty> --%>
    <jsp:setProperty name="user" property="id" value="${user.id}"/>
    <jsp:setProperty name="user" property="username" value="${user.username}"/>
    <jsp:setProperty name="user" property="email" value="${user.email}"/>
    
    <form action="user?action=update" method="post">
        <input type="hidden" name="id" value="<jsp:getProperty name="user" property="id"/>">
        <label for="username">Nom d'utilisateur:</label>
        <input type="text" id="username" name="username" value="<jsp:getProperty name="user" property="username"/>" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<jsp:getProperty name="user" property="email"/>" required><br><br>
        <input type="submit" value="Modifier">
    </form>
    <a href="index.jsp">Retour à la liste des utilisateurs</a>
</body>
</html>
