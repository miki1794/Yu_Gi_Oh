<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/registration.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Styles.css">
    <title>Registrazione</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<main>
    <div class="registration-container">
        <form action="registrazione" method="POST" class="registration-form">
            <fieldset>
                <legend class="biglabel">Registrazione</legend>

                <div class="form-group">

                    <label for="username">Username</label><br>
                    <input type="text" id="username" name="username" value="" required placeholder="inserisci username" class="input"><br>

                    <label for="email">Email</label><br>
                    <input type="email" id="email" name="email" placeholder="inserisci email" class="input"><br>

                    <label for="DataDiNascita">Data di nascita:</label><br>
                    <input type="date" id="DataDiNascita" name="DataDiNascita" class="input"><br>

                    <div class="phoneGroup">
                        <div class="nazione">
                            <label for="Nazione">Nazione:</label><br>
                            <select id="Nazione" name="Nazione" required></select>
                        </div>

                        <div class="labelAndInputPhone">
                            <span id="phoneError" class="error-message"></span>
                            <label for="NumeroDiTelefono">Numero di telefono:</label><br>
                            <input type="tel" id="NumeroDiTelefono" name="NumeroDiTelefono" class="input" minlength="10" maxlength="15" required><br>
                        </div>
                    </div>

                    <label for="password">Password</label><br>
                    <input type="password" class ="input "id="password" name="password" placeholder="inserisci password"><br>

                    <label for="conferma-password">Conferma password</label><br>
                    <input type="password" class ="input" id="conferma-password" name="conferma-password" placeholder="conferma password"><br>


                    <input type="submit" value="registrati" class="button">

                </div>
            </fieldset>
        </form>
    </div>
</main>

</body>
<jsp:include page="footer.jsp"></jsp:include>

</html>