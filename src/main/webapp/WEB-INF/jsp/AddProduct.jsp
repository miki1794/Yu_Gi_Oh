<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.HashMap" %>
<%
    HashMap<String, String> userData = (HashMap<String, String>) session.getAttribute("map");
    boolean isLoggedIn = (userData != null && "true".equals(userData.get("isLogged")));
    boolean isAdmin = isLoggedIn && "admin".equals(userData.get("ruolo"));

    if (!isAdmin) {
        response.sendRedirect("Home");
        return;
    }
%>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/addproduct.css">
    <title>Aggiungi Prodotto</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="mainpage">
    <h2>Aggiungi un nuovo Prodotto</h2>

    <% if (request.getAttribute("errorMessage") != null) { %>
    <p class="error-message"><%= request.getAttribute("errorMessage") %></p>
    <% } %>

    <form action="AddProduct" method="post">

        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>

        <label for="prezzo">Prezzo:</label>
        <input type="number" id="prezzo" name="prezzo" step="0.01" min="0" required>

        <label for="link">Link Immagine:</label>
        <input type="text" id="link" name="link" required>

        <button type="submit">Aggiungi Prodotto</button>
    </form>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>