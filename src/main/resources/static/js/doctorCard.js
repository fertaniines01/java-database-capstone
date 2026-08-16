function createDoctorCard(doctor) {
    const card = document.createElement("div");
    card.className = "doctor-card";
    card.innerHTML = `
        <h3>Dr. ${doctor.name}</h3>
        <p>Spécialité: ${doctor.specialty}</p>
        <p>Email: ${doctor.email}</p>
    `;
    return card;
}
