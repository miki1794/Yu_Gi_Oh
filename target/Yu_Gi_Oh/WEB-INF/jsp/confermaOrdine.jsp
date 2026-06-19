<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ordine Confermato</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/confermaOrdine.css">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <div class="alert alert-success" role="alert">
        <h1>Ordine Confermato</h1>
        <h3>Puoi ritornare alla home</h3>
        <a href="${pageContext.request.contextPath}/Home">Torna alla Home</a>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>