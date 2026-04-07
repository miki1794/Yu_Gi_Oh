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
        <form action="${pageContext.request.contextPath}/editprofile" method="POST" class="registration-form">
            <fieldset>
                <legend class="biglabel">Modifica Profilo</legend>

                <%-- Messaggi di esito --%>
                <% if (request.getAttribute("errore") != null) { %>
                    <p style="color:red; font-weight:bold;">${errore}</p>
                <% } %>
                <% if (request.getAttribute("messaggio") != null) { %>
                    <p style="color:green; font-weight:bold;">${messaggio}</p>
                <% } %>

                <div class="form-group">

                    <%-- Pre-popola i campi con i dati attuali dalla sessione --%>
                    <%
                        Model.Bean.Utente u = (Model.Bean.Utente) session.getAttribute("utente");
                        String usernameVal   = (u != null && u.getNomeUtente()     != null) ? u.getNomeUtente()     : "";
                        String emailVal      = (u != null && u.getEmail()          != null) ? u.getEmail()          : "";
                        String telefonoVal   = (u != null && u.getNumeroTelefono() != null) ? u.getNumeroTelefono() : "";
                        String dataNascitaVal= (u != null && u.getDataNascita()    != null) ? u.getDataNascita().toString() : "";
                    %>

                    <label for="username">Username</label><br>
                    <input type="text" id="username" name="username"
                           value="<%= usernameVal %>"
                           placeholder="inserisci username" class="input"><br>

                    <label for="email">Email</label><br>
                    <input type="email" id="email" name="email"
                           value="<%= emailVal %>"
                           placeholder="inserisci email" class="input"><br>

                    <label for="DataDiNascita">Data di nascita:</label><br>
                    <input type="date" id="DataDiNascita" name="DataDiNascita"
                           value="<%= dataNascitaVal %>"
                           class="input"><br>

                    <label for="NumeroDiTelefono">Numero di telefono:</label><br>
                    <input type="tel" id="NumeroDiTelefono" name="NumeroDiTelefono"
                           value="<%= telefonoVal %>"
                           class="input" minlength="10" maxlength="15"><br>

                    <label for="password">Nuova Password <small>(lascia vuoto per non cambiare)</small></label><br>
                    <input type="password" id="password" name="password"
                           placeholder="nuova password" class="input"><br>

                    <label for="conferma-password">Conferma nuova Password</label><br>
                    <input type="password" id="conferma-password" name="conferma-password"
                           placeholder="conferma password" class="input"><br>

                    <input type="submit" value="Salva modifiche" class="button">

                </div>
            </fieldset>
        </form>
    </div>
</main>

<jsp:include page="footer.jsp"/>
<script type="text/javascript" src="script/Regioni.js"></script>

</body>
</html>
