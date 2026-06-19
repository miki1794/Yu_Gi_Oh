<%@ page import="java.util.List" %>
<%@ page import="Model.Bean.Carta" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ProductList.css">

    <title>ListaProdotti</title>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="page-container">

    <div class="mainpage">

        <div class="Product-list">
            <ul>
                <%
                    List<Carta> products = (List<Carta>) request.getAttribute("products");
                    if (products == null) {
                        out.println("<p>Product list is null.</p>");
                    } else if (products.isEmpty()) {
                        out.println("<p>Product list is empty.</p>");
                    } else {
                        for (Carta product: products) {
                %>
                <li>
                    <%
                        String img_Path = product.getLink();
                        String imgSrc = (img_Path == null || img_Path.trim().isEmpty()) ? "assets/pictureplaceholder.jpg" : img_Path;
                    %>
                    <a href="${pageContext.request.contextPath}/Prodotto?id=<%= product.getId() %>">
                        <img src="<%= imgSrc %>" alt="<%= product.getNome()%>">
                    </a>

                    <a href="${pageContext.request.contextPath}/Prodotto?id=<%= product.getId() %>">
                        <strong><%= product.getNome() %></strong>
                    </a>- &euro;<%= product.getPrezzo() %>
                </li>
                <%
                        }
                    }
                %>

            </ul>
        </div>


    </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>