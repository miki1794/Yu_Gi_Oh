<%@ page import="Model.Bean.Carta" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Styles.css">
    <%
        Carta nomeCarta=(Carta)request.getAttribute("carta");
        String nCarta=(nomeCarta!=null)?nomeCarta.getNome():"prodotto sconosciuto";
    %>

    <title><%= nCarta%></title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="conteiner">
    <div class=" immagine-prodotto">
        <%
            String path=nomeCarta.getLink();
            String imgSrc = (path == null || path.trim().isEmpty()) ? "assets/pictureplaceholder.jpg" :path;
        %>
        <img src="<%= imgSrc %>" alt="<%=nomeCarta.getNome()%>">
    </div>

        <div class="dettagli">
            <p>
                <strong>
                    Nome:
                </strong>
                <%=
                nomeCarta.getNome()
                %>
            </p>
            <p><strong>
               Prezzo:
            </strong>
                &euro
                <%=
                    nomeCarta.getPrezzo()

                %>
            </p>
        </div>
</div>



</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>
