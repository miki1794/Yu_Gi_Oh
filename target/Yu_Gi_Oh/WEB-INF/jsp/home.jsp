<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css?v=2.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Styles.css">
    <title>home</title>
</head>


<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="conteiner">
    <a href="ListaProdotti">
        <h1> Prodotti</h1>
    </a>

    <div class="slideshow">
        <div class="slide">
            <img src="${pageContext.request.contextPath}/assets/img1.jpg" alt="img1">
        </div>

        <div class="slide">
            <img src="${pageContext.request.contextPath}/assets/img2.jpg" alt="img2">
        </div>

        <div class="slide">
            <img src="${pageContext.request.contextPath}/assets/img3.jpg" alt="img3">
        </div>

        <a class="left" onclick="changeSlide(-1)" tabindex="0" aria-label="Slide precedente">&#10094;</a>
        <a class="right" onclick="changeSlide(1)" tabindex="0" aria-label="Slide successiva">&#10095;</a>

    </div>
    <div class="bestseller"></div>
    <div class="titolo">
        <h2>
            Riguardo me:
        </h2>
    </div>
    <div class="testo">
        <p>
            Sono michele polverino.Passo le giornate a programmare, ma le mie notti sono riservate a testare nuove combo e scalare il ranking. ho deciso di unire i miei due mondi per creare una piattaforma di vendita di carte
        </p>
    </div>

</div>

<script src="${pageContext.request.contextPath}/script/SlideShow.js"></script>
</body>
<jsp:include page="footer.jsp"></jsp:include>