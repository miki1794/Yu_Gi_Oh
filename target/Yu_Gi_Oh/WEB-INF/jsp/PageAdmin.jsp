<%@ page import="java.util.HashMap" %>
<%
  HashMap<String, String> userData = (HashMap<String, String>) session.getAttribute("map");
%>

<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pageAdmin.css">
  <title>Admin</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="mainpage">

  <h1>Benvenuto <%= userData.get("username") %>!</h1>

  <div class="gestione">
    <a href="${pageContext.request.contextPath}/AddProduct">
      <button class="addproductbtn">Aggiungi prodotto</button>
    </a>
    <a href="${pageContext.request.contextPath}/ManageOrder">
      <button class="manageordersbtn">Gestisci Ordini</button>
    </a>
  </div>

</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>