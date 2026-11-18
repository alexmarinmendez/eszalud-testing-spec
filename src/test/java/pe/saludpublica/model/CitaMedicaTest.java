package pe.saludpublica.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class CitaMedicaTest {

    @Test
    @DisplayName("CIT-001 | Crear cita médica con datos válidos")
    void debeCrearCitaMedicaConDatosValidos() {

        CitaMedica cita = new CitaMedica(
                "6af71e0b501cca046a166049",
                "6af7271e501cca046a16604f",
                "6af71da3501cca046a166045",
                "2026-11-23 16:30",
                "Dolor abdominal",
                "PROGRAMADA"
        );

        assertEquals("6af71e0b501cca046a166049", cita.getPatientId());
        assertEquals("6af7271e501cca046a16604f", cita.getDoctorId());
        assertEquals("6af71da3501cca046a166045", cita.getSpecialtyId());
        assertEquals("2026-11-23 16:30", cita.getFechaHora());
        assertEquals("Dolor abdominal", cita.getMotivo());
        assertEquals("PROGRAMADA", cita.getEstado());
    }

    @Test
    @DisplayName("CIT-002 | Rechazar cita sin identificador de paciente")
    void debeRechazarPatientIdNulo() {

        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(
                        null,
                        "6af7271e501cca046a16604f",
                        "6af71da3501cca046a166045",
                        "2026-11-23 16:30",
                        "Dolor abdominal",
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("CIT-003 | Rechazar cita sin identificador de doctor")
    void debeRechazarDoctorIdNulo() {

        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(
                        "6af71e0b501cca046a166049",
                        null,
                        "6af71da3501cca046a166045",
                        "2026-11-23 16:30",
                        "Dolor abdominal",
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("CIT-004 | Rechazar cita sin identificador de especialidad")
    void debeRechazarSpecialtyIdNulo() {

        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(
                        "6af71e0b501cca046a166049",
                        "6af7271e501cca046a16604f",
                        null,
                        "2026-11-23 16:30",
                        "Dolor abdominal",
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("CIT-005 | Rechazar cita sin fecha y hora")
    void debeRechazarFechaHoraNula() {

        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(
                        "6af71e0b501cca046a166049",
                        "6af7271e501cca046a16604f",
                        "6af71da3501cca046a166045",
                        null,
                        "Dolor abdominal",
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("CIT-006 | Rechazar cita con estado nulo")
    void debeRechazarEstadoNulo() {

        assertThrows(IllegalArgumentException.class, () ->
                new CitaMedica(
                        "6af71e0b501cca046a166049",
                        "6af7271e501cca046a16604f",
                        "6af71da3501cca046a166045",
                        "2026-11-23 16:30",
                        "Dolor abdominal",
                        null
                )
        );
    }

    @Test
    @DisplayName("CIT-007 | Conservar correctamente un estado válido")
    void debeConservarEstadoValido() {

        CitaMedica cita = new CitaMedica(
                "6af71e0b501cca046a166049",
                "6af7271e501cca046a16604f",
                "6af71da3501cca046a166045",
                "2026-11-23 16:30",
                "Dolor abdominal",
                "ATENDIDA"
        );

        assertEquals("ATENDIDA", cita.getEstado());
    }

    @Test
    @DisplayName("CIT-008: Verificar atributos después de construir el objeto")
    void debeVerificarTodosLosAtributos() {

        CitaMedica cita = new CitaMedica(
                "6af71e0b501cca046a166049",
                "6af7271e501cca046a16604f",
                "6af71da3501cca046a166045",
                "2026-11-23 16:30",
                "Dolor abdominal",
                "PROGRAMADA"
        );

        assertEquals("6af71e0b501cca046a166049", cita.getPatientId());
        assertEquals("6af7271e501cca046a16604f", cita.getDoctorId());
        assertEquals("6af71da3501cca046a166045", cita.getSpecialtyId());
        assertEquals("2026-11-23 16:30", cita.getFechaHora());
        assertEquals("Dolor abdominal", cita.getMotivo());
        assertEquals("PROGRAMADA", cita.getEstado());
    }
}