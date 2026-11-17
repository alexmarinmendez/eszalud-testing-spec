package pe.saludpublica.model;

import java.time.LocalDateTime;

public class Appointment {

    private String patient;
    private String doctor;
    private String specialty;
    private LocalDateTime dateTime;
    private String reason;
    AppointmentStatus status;

    public Appointment(String patient, String doctor, String specialty, LocalDateTime dateTime, String reason, AppointmentStatus status) {
        validateRequired(patient, "El paciente de la cita es obligatorio");
        this.patient = patient;
        this.doctor = doctor;
        this.specialty = specialty;
        this.dateTime = dateTime;
        this.reason = reason;
        this.status = status;
    }

    private static void validateRequired(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public String getPatient() {
        return patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getSpecialty() {
        return specialty;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getReason() {
        return reason;
    }

    public AppointmentStatus getStatus() {
        return status;
    }
}
