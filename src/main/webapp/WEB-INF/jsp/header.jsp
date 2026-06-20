<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%
    Map<String, String> userData = null;
    String ruolo = "default";
    String username = "";
    boolean isLogged = false;

    if (session != null) {
        userData = (Map<String, String>) session.getAttribute("map");
        if (userData != null) {
            ruolo = userData.getOrDefault("ruolo", "default");
            username = userData.getOrDefault("username", "");
            isLogged = "true".equals(userData.get("isLogged"));
        }
    }
    boolean isAdmin = "admin".equals(ruolo);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Styles.css">
    <title>header</title>
</head>
<body>
<header class="header">
    <div class="header-links">
        <a href="${pageContext.request.contextPath}/Home">Home</a>
        <a href="${pageContext.request.contextPath}/ListaProdotti">Catalogo</a>
        <div id="rightsection"
             data-logged="<%= isLogged %>"
             data-username="<%= username %>"
             data-context="${pageContext.request.contextPath}">
        </div>
        <div class="admin-check">
            <% if (isAdmin) { %>
            <button onclick="window.location.href='${pageContext.request.contextPath}/PageAdmin'">Pannello Admin</button>
            <% } %>
        </div>
    </div>
    <div class="search-box">
        <form action="${pageContext.request.contextPath}/Search" method="get">
            <label for="keyword">Cerca carta:</label>
            <input type="text" id="keyword" name="keyword" placeholder="Cerca carta (es: Drago Bianco)...">
            <button type="submit">Cerca</button>
        </form>
    </div>
    <script src="${pageContext.request.contextPath}/script/ProfileChanger.js"></script>
</header>
</body>
</html>