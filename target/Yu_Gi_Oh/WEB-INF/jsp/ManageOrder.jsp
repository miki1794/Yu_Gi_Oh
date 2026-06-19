<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ManageOrder.css">
  <title>AdminOrders</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="manageorderscontainer">
  <h2>Tutti gli ordini</h2>

  <c:choose>
    <c:when test="${empty orders}">
      <p>Orders list is empty.</p>
    </c:when>
    <c:otherwise>
      <table border="1">
        <tr>
          <th>ID</th>
          <th>Utente</th>
          <th>Stato</th>
          <th>Totale</th>
          <th>Data</th>
          <th>Modifica</th>
        </tr>
        <c:forEach var="order" items="${orders}">
          <tr>
            <td>${order.id}</td>
            <td>${order.utente}</td>
            <td>${order.stato}</td>
            <td>${order.prezzoTot}</td>
            <td>${order.dataOrdine}</td>
            <td>
              <a href="${pageContext.request.contextPath}/OrderDetails?id=${order.id}">
                <button class="orderdetailsbtn">Dettagli</button>
              </a>
            </td>
          </tr>
        </c:forEach>
      </table>
    </c:otherwise>
  </c:choose>

</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>