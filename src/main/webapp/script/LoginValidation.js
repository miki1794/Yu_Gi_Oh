function validateLoginForm() {

    var errors = [];

    document.querySelectorAll('.error-message').forEach(function (error) {
        error.textContent = '';
    });

    document.querySelectorAll('input').forEach(function (input) {
        input.style.removeProperty("border");
    });

    var username = document.getElementById("Username").value;
    if (!username || username.trim() === "") {
        document.getElementById("Username").style.border = "2px solid red";
        document.getElementById("UsernameError").textContent = "Inserisci il tuo username";
        errors.push("Username mancante");
    }

    var password = document.getElementById("Password").value;
    if (!password || password.trim() === "") {
        document.getElementById("Password").style.border = "2px solid red";
        document.getElementById("PasswordError").textContent = "Inserisci la tua password";
        errors.push("Password mancante");
    }

    if (errors.length > 0) {
        return false;
    }

    return true;
}

document.querySelectorAll("input").forEach(function (input) {
    input.addEventListener("input", function () {
        this.style.removeProperty("border");
        var errorId = this.id + "Error";
        var errorElement = document.getElementById(errorId);
        if (errorElement) {
            errorElement.textContent = "";
        }
    });
});