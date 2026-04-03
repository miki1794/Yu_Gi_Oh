<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Styles.css">
    <title>Registrazione</title>
</head>


<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="conteiner">
    <a href="prodotti">
        <button>prodotti</button>
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

        <div class="slide">
            <img src="${pageContext.request.contextPath}/assets/img4.jpg" alt="img4">
        </div>
        <div class="slide">
            <img src="${pageContext.request.contextPath}/assets/img5.jpg" alt="img5">
        </div>
        <div class="slide">
            <img src="${pageContext.request.contextPath}/assets/img6.jpg" alt="img6">
        </div>
        <div class="slide">
            <img src="${pageContext.request.contextPath}/assets/img7.jpg" alt="img7">
        </div>
        <div class="slide">
            <img src="${pageContext.request.contextPath}/assets/img8.jpg" alt="img8">
        </div>
        <a class="left" onclick="changeSlide(-1)"></a>

        <a class="right" onclick="changeSlide(1)"></a>

    </div>
    <div class="bestseller"></div>
    <div class="titolo">

        <h1>
            riguardo me:

        </h1>

    </div>
    <div class=testo>
        <p>
            Sono michele polverino.Passo le giornate a programmare, ma le mie notti sono riservate a testare nuove combo e scalare il ranking. ho deciso di unire i miei due mondi per creare una piattaforma di vendita di carte
        </p>

    </div>




</div>

<jsp:include page="footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/script/SlideShow.js"></script>
</body>


