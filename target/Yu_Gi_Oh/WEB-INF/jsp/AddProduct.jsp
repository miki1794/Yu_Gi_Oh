<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.HashMap" %>
<%
    HashMap<String, String> userData = (HashMap<String, String>) session.getAttribute("map");
    boolean isLoggedIn = (userData != null && "true".equals(userData.get("isLogged")));
    boolean isAdmin = isLoggedIn && "admin".equals(userData.get("ruolo"));

    if (!isAdmin) {
        response.sendRedirect(request.getContextPath() + "/Home");
        return;
    }
%>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AddProduct.css">
    <title>Aggiungi Prodotto</title>

</head>

<body>
<jsp:include page="header.jsp"/>

<div class="mainpage">
    <h2>Aggiungi un nuovo Prodotto</h2>

    <% if (request.getAttribute("errorMessage") != null) { %>
    <p class="error-message"><%= request.getAttribute("errorMessage") %></p>
    <% } %>

    <!-- 🔥 IMPORTANTE -->
    <form action="${pageContext.request.contextPath}/AddProduct" method="post" enctype="multipart/form-data">

        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>

        <label for="prezzo">Prezzo:</label>
        <input type="number" id="prezzo" name="prezzo" step="0.01" min="0" required>

        <!-- 🔽 DRAG & DROP -->
        <label id="dropZoneLabel">Immagine prodotto:</label>

        <input type="file" id="fileInput" name="link" hidden accept="image/*">

        <div id="dropZone" tabindex="0" role="button" aria-labelledby="dropZoneLabel" aria-label="Trascina qui l'immagine o premi Invio per selezionarla">
            Trascina qui l'immagine o clicca per selezionarla
        </div>

        <img id="preview" class="preview" style="display:none;" alt="Anteprima immagine prodotto"/>

        <button type="submit">Aggiungi Prodotto</button>
    </form>
</div>

<jsp:include page="footer.jsp"/>

<script>
    const dropZone = document.getElementById("dropZone");
    const fileInput = document.getElementById("fileInput");
    const preview = document.getElementById("preview");

    dropZone.addEventListener("click", () => fileInput.click());

    dropZone.addEventListener("keydown", (e) => {
        if (e.key === "Enter" || e.key === " ") {
            e.preventDefault();
            fileInput.click();
        }
    });

    dropZone.addEventListener("dragover", (e) => {
        e.preventDefault();
        dropZone.style.background = "#f0f0f0";
    });

    dropZone.addEventListener("dragleave", () => {
        dropZone.style.background = "white";
    });

    dropZone.addEventListener("drop", (e) => {
        e.preventDefault();
        fileInput.files = e.dataTransfer.files;
        showPreview();
    });

    fileInput.addEventListener("change", showPreview);

    function showPreview() {
        const file = fileInput.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function(e) {
                preview.src = e.target.result;
                preview.style.display = "block";
            };
            reader.readAsDataURL(file);
        }
    }
</script>

</body>
</html>