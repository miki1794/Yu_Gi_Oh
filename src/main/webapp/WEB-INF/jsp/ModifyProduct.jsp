<%@ page import="Model.Bean.Carta" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="./css/styles.css">
  <link rel="stylesheet" href="./css/modifyproduct.css">
  <title>Modifica Prodotto</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>


<div class="mainpage">
  <h2>Modifica Prodotto</h2>

  <form action="UpdateProduct" method="POST">

    <%
      Carta product = (Carta) request.getAttribute("product");
    %>

    <input type="hidden" name="id" value="<%= product.getId() %>">

    <div class="product-container">

      <div class="product-image">
        <%
          String imgPath = product.getLink();
          String imgSrc = (imgPath == null || imgPath.trim().isEmpty()) ? "assets/images/pictureplaceholder.jpg" : imgPath;
        %>

        <img src="<%= imgSrc %>" alt="<%= product.getNome()%>">
      </div>
      <div class="product-details">

        <div>
          <label for="nome">Nome:</label>
          <input type="text" id="nome" name="nome" value="<%= product.getNome() %>" required />
        </div>

        <div name="prezzo">
          <label for="prezzo">Prezzo:</label>
          <input type="number" id="prezzo" name="prezzo" value="<%= product.getPrezzo() %>" required />
        </div>



        <button type="submit">Aggiorna Prodotto</button>
      </div>
    </div>
  </form>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>