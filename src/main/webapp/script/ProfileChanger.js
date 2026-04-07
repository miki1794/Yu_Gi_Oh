document.addEventListener('DOMContentLoaded', function () {
    let profileChanger = document.getElementById('rightsection');
    let isLogged = profileChanger.dataset.logged === "true";
    let username = profileChanger.dataset.username;

    if (isLogged) {
        console.log(username);

        profileChanger.innerHTML = `
            <a href="editprofile">
                <h3>Profilo</h3>
            </a>
            <button class="logout" onclick="logout()">Logout</button>
        `;
    } else {
        profileChanger.innerHTML = `
            <a href="login">Login</a>
            <a href="registrazione">Registrati</a>
        `;
    }
});

function logout() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "Logout", true);
    xhr.onload = function() {
        if (xhr.status === 200) {
            location.reload();
        }
    };
    xhr.onerror = function() {
        console.error("Errore nel logout:", xhr.statusText);
    };
    xhr.send();
}










