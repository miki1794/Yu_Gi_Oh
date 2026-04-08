<%@ page import="java.util.Map" %>
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
        <a href="Home">Home</a>
        <a href="catalogo">Catalogo</a>

        <%
            Map map = (Map) session.getAttribute("map");
            boolean isLogged = map != null && "true".equals(String.valueOf(map.get("isLogged")));
            String username = map != null && map.get("username") != null ? (String) map.get("username") : "";
        %>

        <div id="rightsection"
             data-logged="<%= isLogged %>"
             data-username="<%= username %>">
        </div>
    </div>

    <div class="search-box">
        <input type="text" placeholder="Cerca carta (es: Drago Bianco)...">
        <button>Trova</button>
    </div>

    <script src="${pageContext.request.contextPath}/script/ProfileChanger.js"></script>
</header>

</body>
</html>