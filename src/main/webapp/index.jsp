<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="User.UserBean" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des utilisateurs</title>
</head>
<body>
    <h1>Liste des utilisateurs</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%-- Iterate over the users list using a for loop --%>
            <% List<UserBean> users = (List<UserBean>) request.getAttribute("users"); %>
            <% if (users != null) { %>
                <% for (int i = 0; i < users.size(); i++) { %>
                    <jsp:useBean id="user" class="User.UserBean" scope="page" />
                    <jsp:setProperty name="user" property="*" value="<%= users.get(i) %>" />
                    <tr>
                        <td><jsp:getProperty name="user" property="id"/></td>
                        <td><jsp:getProperty name="user" property="username"/></td>
                        <td><jsp:getProperty name="user" property="email"/></td>
                        <td>
                            <a href="user?action=edit&id=<jsp:getProperty name="user" property="id"/>">Modifier</a>
                            <a href="user?action=delete&id=<jsp:getProperty name="user" property="id"/>">Supprimer</a>
                        </td>
                    </tr>
                <% } %>
            <% } %>
        </tbody>
    </table>
    <a href="add_user.jsp">Ajouter un utilisateur</a>
</body>
</html>