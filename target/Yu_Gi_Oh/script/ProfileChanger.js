document.addEventListener('DOMContentLoaded', function () {

    let profileChanger = document.getElementById('rightsection');

    let IsLogged = profileChanger.dataset.logged === "true";
    let username = profileChanger.dataset.username;
    let contextPath = profileChanger.dataset.context;

    if (IsLogged) {
        profileChanger.innerHTML = `
            <a href="${contextPath}/editprofile">
                <h3>Profilo ${username}</h3>
            </a>
            <button class="logout" onclick="logout('${contextPath}')">Logout</button>
        `;
    } else {
        profileChanger.innerHTML = `
            <a href="${contextPath}/login">Login</a>
            <a href="${contextPath}/registrazione">Registrati</a>
        `;
    }
});

function logout(contextPath) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", contextPath + "/Logout", true);

    xhr.onload = function() {
        if (xhr.status === 200) {
            window.location.href = contextPath + "/Home";
        }
    };

    xhr.onerror = function() {
        console.error("Errore nel logout:", xhr.statusText);
    };

    xhr.send();
}