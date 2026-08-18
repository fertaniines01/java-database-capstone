# Database Schema Design

## 1. Table: users
Stores system authentication details for all user types.
- `id` (BIGINT, PRIMARY KEY, AUTO_INCREMENT)
- `email` (VARCHAR(255), UNIQUE, NOT NULL)
- `password` (VARCHAR(255), NOT NULL)
- `role` (VARCHAR(50), NOT NULL) -- ADMIN, DOCTOR, PATIENT

## 2. Table: doctors
Contains specific information about medical staff.
- `id` (BIGINT, PRIMARY KEY, AUTO_INCREMENT)
- `user_id` (BIGINT, NOT NULL)
- `name` (VARCHAR(255), NOT NULL)
- `specialty` (VARCHAR(255), NOT NULL)
- `email` (VARCHAR(255), UNIQUE, NOT NULL)
- **FOREIGN KEY** (`user_id`) REFERENCES `users`(`id`) ON DELETE CASCADE

## 3. Table: patients
Stores detailed personal profiles of registered patients.
- `id` (BIGINT, PRIMARY KEY, AUTO_INCREMENT)
- `user_id` (BIGINT, NOT NULL)
- `first_name` (VARCHAR(255), NOT NULL)
- `last_name` (VARCHAR(255), NOT NULL)
- `email` (VARCHAR(255), UNIQUE, NOT NULL)
- `phone` (VARCHAR(50), NOT NULL)
- **FOREIGN KEY** (`user_id`) REFERENCES `users`(`id`) ON DELETE CASCADE

## 4. Table: appointments
Manages scheduled consultations between patients and doctors.
- `id` (BIGINT, PRIMARY KEY, AUTO_INCREMENT)
- `doctor_id` (BIGINT, NOT NULL)
- `patient_id` (BIGINT, NOT NULL)
- `appointment_time` (DATETIME, NOT NULL)
- `status` (VARCHAR(50), NOT NULL) -- SCHEDULED, CONFIRMED, CANCELLED
- **FOREIGN KEY** (`doctor_id`) REFERENCES `doctors`(`id`) ON DELETE CASCADE
- **FOREIGN KEY** (`patient_id`) REFERENCES `patients`(`id`) ON DELETE CASCADE

## 5. Table: prescriptions
Tracks medical prescriptions issued during appointments.
- `id` (BIGINT, PRIMARY KEY, AUTO_INCREMENT)
- `appointment_id` (BIGINT, NOT NULL)
- `doctor_id` (BIGINT, NOT NULL)
- `patient_id` (BIGINT, NOT NULL)
- `medication` (VARCHAR(255), NOT NULL)
- `dosage` (VARCHAR(255), NOT NULL)
- **FOREIGN KEY** (`appointment_id`) REFERENCES `appointments`(`id`) ON DELETE CASCADE
- **FOREIGN KEY** (`doctor_id`) REFERENCES `doctors`(`id`) ON DELETE CASCADE
- **FOREIGN KEY** (`patient_id`) REFERENCES `patients`(`id`) ON DELETE CASCADE

## Relationships Summary
- `users` (1) <---> (1) `doctors` via `doctors.user_id`
- `users` (1) <---> (1) `patients` via `patients.user_id`
- `doctors` (1) <---> (N) `appointments` via `appointments.doctor_id`
- `patients` (1) <---> (N) `appointments` via `appointments.patient_id`
- `appointments` (1) <---> (N) `prescriptions` via `prescriptions.appointment_id`
