package com.example.demo.service;

import com.example.demo.dto.AppointmentDTO;
import java.util.List;

public interface AppointmentService {
    AppointmentDTO createAppointment(AppointmentDTO dto);
    List<AppointmentDTO> getAllAppointments();
    AppointmentDTO getAppointmentById(Long id);
    AppointmentDTO updateAppointment(Long id, AppointmentDTO dto);
    void deleteAppointment(Long id);
}
