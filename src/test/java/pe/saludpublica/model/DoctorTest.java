package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor("11112222", "Carlos", "Ruiz", "CMP-1234", "E001");
        assertNotNull(doctor);
        assertEquals("11112222", doctor.getDocumento());
        assertEquals("Carlos", doctor.getNombres());
        assertEquals("Ruiz", doctor.getApellidos());
        assertEquals("CMP-1234", doctor.getColegiatura());
        assertEquals("E001", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("Conservar los atributos después de construir el doctor")
    void shouldKeepAttributesAfterConstruction() {
        Doctor doctor = new Doctor("33334444", "María", "Torres", "CMP-5678", "E002");
        assertEquals("33334444", doctor.getDocumento());
        assertEquals("María", doctor.getNombres());
        assertEquals("Torres", doctor.getApellidos());
        assertEquals("CMP-5678", doctor.getColegiatura());
        assertEquals("E002", doctor.getEspecialidad());
    }
}