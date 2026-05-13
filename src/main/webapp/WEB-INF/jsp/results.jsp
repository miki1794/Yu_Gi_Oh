<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Carta" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./css/styles.css">
    <link rel="stylesheet" href="./css/product.css">


    <title>Risultati Ricerca</title>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="page-container">


    <div class="mainpage">
        <%
            String keyword = (String) request.getAttribute("keyword");

            if (keyword == null || keyword.trim().isEmpty()) {
                out.println("<h2>Inserisci una parola chiave</h2>");
            } else {
        %>

        <h2>Risultati per: "<%= keyword %>"</h2>

        <div class="Product-list">
            <ul>
                <%
                    List<Carta> searchResults = (List<Carta>) request.getAttribute("result");
                    if (searchResults == null) {
                        out.println("<p>Search results are null.</p>");
                    } else if (searchResults.isEmpty()) {
                        out.println("<p>Non ci sono risultati.</p>");
                    } else {
                        for (Carta carta: searchResults) {
                %>
                <li>
                    <%
                        String imgPath = carta.getLink();
                        String imgSrc = (imgPath == null || imgPath.trim().isEmpty()) ? "assets/images/pictureplaceholder.jpg" : imgPath;
                    %>
                    <a href="Prodotto?id=<%= carta.getId() %>">
                        <img src="<%= imgSrc %>" alt="<%=carta.getNome()%>">
                    </a>
                    <a href="Prodotto?id=<%= carta.getId() %>" aria-label="Visualizza dettagli di <%= carta.getNome() %>">
                        <strong><%= carta.getNome() %></strong>
                    </a> - &euro;<%= carta.getPrezzo() %>
                </li>
                <%
                        }
                    }
                %>
            </ul>
        </div>

        <% } %>

    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
