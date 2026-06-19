<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Contatti.css">
    <title>Contact us</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <div class="contact">

        <h1>Contattaci</h1>
        <p>Se hai bisogno di informazioni o delle nostre offerte, non esitare a contattarci.</p>

        <div class="contact-info">

            <label>email: </label>
            <a href="mailto:mpolverino140602@gmail.com">mpolverino140602@gmail.com</a>
            <label>telefono: </label>
            <a href="tel:+393914852508">+393914852508</a>

        </div>

    </div>

</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>