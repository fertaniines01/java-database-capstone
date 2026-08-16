DELIMITER //

-- Procédure 1 : Rapport quotidien des rendez-vous d'un médecin
CREATE PROCEDURE GetDailyDoctorAppointments(
    IN p_doctor_id INT,
    IN p_date DATE
)
BEGIN
    SELECT 
        a.id AS appointment_id,
        a.appointment_time,
        p.first_name,
        p.last_name,
        a.status
    FROM appointments a
    JOIN patients p ON a.patient_id = p.id
    WHERE a.doctor_id = p_doctor_id 
      AND DATE(a.appointment_time) = p_date;
END //

-- Procédure 2 : Médecin ayant le plus de patients sur un mois donné
CREATE PROCEDURE GetTopDoctorOfMonth(
    IN p_month INT,
    IN p_year INT
)
BEGIN
    SELECT 
        d.id AS doctor_id,
        d.first_name,
        d.last_name,
        COUNT(DISTINCT a.patient_id) AS total_patients
    FROM doctors d
    JOIN appointments a ON d.id = a.doctor_id
    WHERE MONTH(a.appointment_time) = p_month 
      AND YEAR(a.appointment_time) = p_year
    GROUP BY d.id, d.first_name, d.last_name
    ORDER BY total_patients DESC
    LIMIT 1;
END //

-- Procédure 3 : Médecin ayant le plus de patients sur une année donnée
CREATE PROCEDURE GetTopDoctorOfYear(
    IN p_year INT
)
BEGIN
    SELECT 
        d.id AS doctor_id,
        d.first_name,
        d.last_name,
        COUNT(DISTINCT a.patient_id) AS total_patients
    FROM doctors d
    JOIN appointments a ON d.id = a.doctor_id
    WHERE YEAR(a.appointment_time) = p_year
    GROUP BY d.id, d.first_name, d.last_name
    ORDER BY total_patients DESC
    LIMIT 1;
END //

DELIMITER ;
