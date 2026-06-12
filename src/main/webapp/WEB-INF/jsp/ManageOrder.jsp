<%@ page import="java.util.ArrayList, Model.Bean.Ordine" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="./css/styles.css">
  <link rel="stylesheet" href="./css/manageorder.css">
  <title>AdminOrders</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>



<div class="manageorderscontainer">
  <h2>Tutti gli ordini</h2>
  <table border="1">

    <tr>
      <th>ID</th>
      <th>Utente</th>
      <th>Stato</th>
      <th>Totale</th>
      <th>Data</th>
      <th>Modifica</th>
    </tr>
    <%


      ArrayList<Ordine> orders = (ArrayList<Ordine>) request.getAttribute("orders");
      if (orders == null) {
        out.println("<p>Orders list is null.</p>");
      } else if (orders.isEmpty()) {
        out.println("<p>Orders list is empty.</p>");
      } else {
        for (Ordine order: orders) {


    %>
    <tr>
      <td><%= order.getId() %></td>
      <td><%= order.getUtente() %></td>
      <td><%= order.getStato() %></td>
      <td><%= order.getPrezzoTot() %></td>
      <td><%= order.getDataOrdine() %></td>
      <td>
        <a href="OrderDetails?id=<%= order.getId() %>">
          <button class="orderdetailsbtn">Dettagli</button></a>
      </td>
    </tr>
    <% }
    }
    %>
  </table>

</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>