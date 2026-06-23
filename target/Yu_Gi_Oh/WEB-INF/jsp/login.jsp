<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/Styles.css">
    <title>login</title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="login-container">
    <form action="${pageContext.request.contextPath}/login" method="POST" class="login-form" onsubmit="return validateLoginForm()">
        <fieldset>
            <legend>Login</legend>

            <c:if test="${not empty errorMessagesJson}">
                <p class="error-message" id="serverError"></p>
                <script>
                    document.getElementById("serverError").innerText =
                        JSON.parse('${errorMessagesJson}').error;
                </script>
            </c:if>

            <div class="form-container">
                <div class="form-group">
                    <span id="UsernameError" class="error-message"></span>
                    <label for="Username">Username:</label>
                    <input type="text" id="Username" name="Username" required placeholder="Inserisci Username" class="input">
                </div>

                <div class="form-group">
                    <span id="PasswordError" class="error-message"></span>
                    <label for="Password">Password:</label>
                    <input type="password" id="Password" name="Password" required placeholder="Inserisci Password" class="input">
                </div>

                <div class="form-actions">
                    <input type="submit" value="Login" class="button">
                </div>
            </div>
        </fieldset>
    </form>
</div>

<jsp:include page="footer.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/script/LoginValidation.js"></script>
</body>
</html>