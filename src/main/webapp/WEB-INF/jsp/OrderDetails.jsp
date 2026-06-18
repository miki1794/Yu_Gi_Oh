<%@ page import="Model.Bean.Ordine" %>
<%@ page import="Model.Bean.ItemOrdine" %>
<%@ page import="Model.Bean.Carta" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="./css/styles.css">
  <link rel="stylesheet" href="./css/OrderDetails.css">
  <title>Order Details</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>



<div class="orderdetails">
  <h2>Dettagli Ordine</h2>
  <%
    Ordine order = (Ordine) request.getAttribute("order");
  %>
  <p><strong>ID:</strong> <%= order.getId() %></p>
  <p><strong>ID Utente:</strong> <%= order.getUtente() %></p>
  <p><strong>Stato:</strong> <%= order.getStato() %></p>
  <p><strong>Totale:</strong> <%= order.getPrezzoTot() %></p>
  <p><strong>Date:</strong> <%= order.getDataOrdine() %></p>

  <div class="update">
    <form action="UpdateStatus" method="post">
      <input type="hidden" name="id" value="<%= order.getId() %>">
      <label for="selectStato" class="sr-only">Cerca:</label>
      <select name="status" id="selectStato">
        <option value="Elaborando">Elaborando</option>
        <option value="Spedito">Spedito</option>
        <option value="Consegnato">Consegnato</option>
      </select>
      <input type="submit" value="Update Status">
    </form>
  </div>
  <div class="Product-list">
    <h3>Prodotti nell'ordine</h3>
    <ul>
      <%
        ArrayList<ItemOrdine> orderItems = (ArrayList<ItemOrdine>) request.getAttribute("orderItems");
        ArrayList<Carta> products = (ArrayList<Carta>) request.getAttribute("products");

        if (orderItems == null || orderItems.isEmpty()) {
          out.println("<p>Nessun prodotto trovato per questo ordine.</p>");
        } else {
          for (int i = 0; i < orderItems.size(); i++) {
            ItemOrdine item = orderItems.get(i);
            Carta product = products.get(i);
      %>
      <li class="product-item">
        <img src="<%= product.getLink() %>" alt="<%= product.getNome() != null ? product.getNome() : "Prodotto" %>" class="product-image">
        <p><strong>Nome:</strong> <%= product.getNome() != null ? product.getNome() : "N/A" %></p>
        <p><strong>Quantità:</strong> <%= item.getQuantita() %></p>
        <p><strong>Prezzo:</strong> €<%= item.getPrezzo() %></p>
      </li>
      <%
          }
        }
      %>
    </ul>
  </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>