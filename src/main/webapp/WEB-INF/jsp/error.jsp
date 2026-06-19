<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">
    <title>Error Page</title>
</head>
<body>

<jsp:include page="../jsp/header.jsp"></jsp:include>

<div class="container">
    <div class="fieldset">
        <div class="biglabel">
            <h1>Errore</h1>
        </div>
        <div class="error">
            <h2>Si è verificato un errore</h2>
            <a href="${pageContext.request.contextPath}/Home">Torna alla Home</a>
        </div>
    </div>
</div>

<jsp:include page="../jsp/footer.jsp"></jsp:include>

</body>
</html>