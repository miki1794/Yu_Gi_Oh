<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/modificaprofilo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Styles.css">
    <title>Modifica Profilo</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<main>
    <div class="registration-container">
        <form action="${pageContext.request.contextPath}/editprofile" method="POST" class="registration-form" autocomplete="off">
            <fieldset>
                <legend class="biglabel">Modifica Profilo</legend>

                <%-- Messaggi di esito --%>
                <c:if test="${not empty errore}">
                    <p style="color:red; font-weight:bold;">${errore}</p>
                </c:if>
                <c:if test="${not empty messaggio}">
                    <p style="color:green; font-weight:bold;">${messaggio}</p>
                </c:if>

                <div class="form-group">

                    <label for="username">Username</label><br>
                    <input type="text" id="username" name="username"
                           value="${sessionScope.utente.nomeUtente}"
                           placeholder="inserisci username" class="input"
                           autocomplete="off"><br>

                    <label for="email">Email</label><br>
                    <input type="email" id="email" name="email"
                           value="${sessionScope.utente.email}"
                           placeholder="inserisci email" class="input"
                           autocomplete="off"><br>

                    <label for="DataDiNascita">Data di nascita:</label><br>
                    <input type="date" id="DataDiNascita" name="DataDiNascita"
                           value="${sessionScope.utente.dataNascita}"
                           class="input" autocomplete="off"><br>

                    <label for="NumeroDiTelefono">Numero di telefono:</label><br>
                    <input type="tel" id="NumeroDiTelefono" name="NumeroDiTelefono"
                           value="${sessionScope.utente.numeroTelefono}"
                           class="input" minlength="10" maxlength="15"
                           autocomplete="off"><br>

                    <label for="password">Nuova Password <small>(lascia vuoto per non cambiare)</small></label><br>
                    <input type="password" id="password" name="password"
                           placeholder="nuova password" class="input"
                           autocomplete="new-password"><br>

                    <label for="conferma-password">Conferma nuova Password</label><br>
                    <input type="password" id="conferma-password" name="conferma-password"
                           placeholder="conferma password" class="input"
                           autocomplete="new-password"><br>

                    <input type="submit" value="Salva modifiche" class="button">

                </div>
            </fieldset>
        </form>
    </div>
</main>

<jsp:include page="footer.jsp"/>

</body>
</html>