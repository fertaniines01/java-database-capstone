# Conception des Schémas de Base de Données - Smart Clinic

## 1. Schéma Relationnel (MySQL)

### Table : users
* `id` (INT, Clé Primaire, Auto-incrément)
* `username` (VARCHAR)
* `password` (VARCHAR)
* `role` (VARCHAR)

### Table : doctors
* `id` (INT, Clé Primaire, Auto-incrément)
* `first_name` (VARCHAR)
* `last_name` (VARCHAR)
* `specialty` (VARCHAR)
* `email` (VARCHAR)

### Table : patients
* `id` (INT, Clé Primaire, Auto-incrément)
* `first_name` (VARCHAR)
* `last_name` (VARCHAR)
* `date_of_birth` (DATE)
* `phone_number` (VARCHAR)

---

## 2. Schéma Basé sur des Documents (MongoDB)

### Collection : appointments
Exemple de structure de document avec données imbriquées :

```json
{
  "_id": "60c72b2f9b1d8b001f8e4a1a",
  "patient_id": 101,
  "doctor_id": 5,
  "appointment_date": "2026-09-15T10:30:00Z",
  "status": "CONFIRMED",
  "prescription": {
    "medications": [
      {
        "name": "Paracetamol",
        "dosage": "500mg",
        "instructions": "1 comprimé toutes les 8 heures"
      }
    ],
    "notes": "Repos recommandé pendant 3 jours."
  }
}
