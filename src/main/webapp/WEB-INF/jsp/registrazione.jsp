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
        <form action="${pageContext.request.contextPath}/registrazione" method="POST" class="registration-form" onsubmit="return validateAndSubmitForm(event)">
            <fieldset>
                <legend class="biglabel">Registrazione</legend>

                <div class="form-group">

                    <span id="usernameError" class="error-message"></span>
                    <label for="Username">Username</label><br>
                    <input type="text" id="Username" name="username" value="" required placeholder="inserisci username" class="input"><br>

                    <span id="emailError" class="error-message"></span>
                    <label for="Email">Email</label><br>
                    <input type="email" id="Email" name="email" placeholder="inserisci email" class="input"><br>

                    <span id="birthDateError" class="error-message"></span>
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

                    <span id="passwordError" class="error-message"></span>
                    <label for="Password">Password</label><br>
                    <input type="password" class="input" id="Password" name="password" placeholder="inserisci password"><br>

                    <span id="cpasswordError" class="error-message"></span>
                    <label for="CPassword">Conferma password</label><br>
                    <input type="password" class="input" id="CPassword" name="conferma-password" placeholder="conferma password"><br>

                    <input type="submit" value="registrati" class="button">

                </div>
            </fieldset>
        </form>
    </div>
</main>

<jsp:include page="footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/script/Regioni.js"></script>
<script src="${pageContext.request.contextPath}/script/RegistrationValidation.js"></script>
</body>
</html>