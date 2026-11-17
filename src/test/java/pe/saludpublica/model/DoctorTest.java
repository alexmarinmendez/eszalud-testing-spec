package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoctorTest {

    @Test
    @DisplayName("Debe crear un doctor correctamente cuando todos los datos son válidos")
    void shouldCreateDoctorWhenDataIsValid() {
        Doctor doctor = new Doctor(
                "87654321",
                "María",
                "López",
                "COL12345",
                "ESP01"
        );

        assertNotNull(doctor);
        assertEquals("87654321", doctor.getDocumento());
        assertEquals("María", doctor.getNombres());
        assertEquals("López", doctor.getApellidos());
        assertEquals("COL12345", doctor.getColegiatura());
        assertEquals("ESP01", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("Debe lanzar IllegalArgumentException cuando el documento es nulo")
    void shouldRejectDoctorWhenDocumentIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Doctor(
                null,
                "María",
                "López",
                "COL12345",
                "ESP01"
        ));
    }

    @Test
    @DisplayName("Debe lanzar IllegalArgumentException cuando los nombres son nulos")
    void shouldRejectDoctorWhenFirstNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Doctor(
                "87654321",
                null,
                "López",
                "COL12345",
                "ESP01"
        ));
    }

    @Test
    @DisplayName("Debe lanzar IllegalArgumentException cuando los apellidos son nulos")
    void shouldRejectDoctorWhenLastNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Doctor(
                "87654321",
                "María",
                null,
                "COL12345",
                "ESP01"
        ));
    }

    @Test
    @DisplayName("Debe lanzar IllegalArgumentException cuando la colegiatura es nula")
    void shouldRejectDoctorWhenLicenseIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Doctor(
                "87654321",
                "María",
                "López",
                null,
                "ESP01"
        ));
    }

    @Test
    @DisplayName("Debe devolver todos los atributos asignados mediante sus getters tras construir el doctor")
    void shouldReturnAssignedAttributesAfterDoctorConstruction() {
        Doctor doctor = new Doctor(
                "11223344",
                "Carlos",
                "Ruiz",
                "COL98765",
                null
        );

        assertAll(
                () -> assertEquals("11223344", doctor.getDocumento()),
                () -> assertEquals("Carlos", doctor.getNombres()),
                () -> assertEquals("Ruiz", doctor.getApellidos()),
                () -> assertEquals("COL98765", doctor.getColegiatura()),
                () -> assertNull(doctor.getEspecialidad())
        );
    }
}
