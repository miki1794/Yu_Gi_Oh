document.addEventListener('DOMContentLoaded', function () {
    let profileChanger = document.getElementById('rightsection');
    if (!profileChanger) return;

    let isLogged = profileChanger.dataset.logged === "true";
    let username = profileChanger.dataset.username;

    // Recuperiamo il contesto dell'app (es: /Yu_Gi_Oh_war_exploded)
    // Se non funziona, sostituisci con il nome manuale della tua cartella
    let contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1));

    if (isLogged) {
        profileChanger.innerHTML = `
            <div class="user-menu">
                <a href="${contextPath}/editprofile">
                    <h3>Profilo di ${username}</h3>
                </a>
                <button class="logout" onclick="logout()">Logout</button>
            </div>
        `;
    } else {
        profileChanger.innerHTML = `
            <a href="${contextPath}/login">Login</a>
            <a href="${contextPath}/registrazione">Registrati</a>
        `;
    }
});

function logout() {
    let contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1));
    var xhr = new XMLHttpRequest();
    xhr.open("GET", contextPath + "/Logout", true);
    xhr.onload = function() {
        if (xhr.status === 200) {
            location.href = contextPath + "/Home";
        }
    };
    xhr.send();
}