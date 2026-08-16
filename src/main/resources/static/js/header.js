document.addEventListener("DOMContentLoaded", () => {
    const header = document.getElementById("main-header");
    const role = localStorage.getItem("userRole");
    const token = localStorage.getItem("token");

    let navLinks = '<a href="index.html">Accueil</a> ';
    if (token) {
        if (role === "ADMIN") {
            navLinks += '| <a href="adminDashboard.html">Admin Dashboard</a> ';
        } else if (role === "DOCTOR") {
            navLinks += '| <a href="doctorDashboard.html">Doctor Dashboard</a> ';
        }
        navLinks += '| <button onclick="localStorage.clear(); location.reload();">Déconnexion</button>';
    } else {
        navLinks += '| <a href="#">Connexion</a>';
    }

    header.innerHTML = `<nav>${navLinks}</nav><hr>`;
});
