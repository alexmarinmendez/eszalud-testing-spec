package pe.saludpublica.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor(
                "12345678",
                "Juan",
                "Perez",
                "CMP12345",
                "Cardiologia"
        );

        assertNotNull(doctor);
        assertEquals("12345678", doctor.getDocumento());
        assertEquals("Juan", doctor.getNombres());
        assertEquals("Perez", doctor.getApellidos());
        assertEquals("CMP12345", doctor.getColegiatura());
        assertEquals("Cardiologia", doctor.getEspecialidad());
    }

    @Test
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        null,
                        "Juan",
                        "Perez",
                        "CMP12345",
                        "Cardiologia"
                )
        );
    }

    @Test
    void shouldRejectDoctorWithoutNames() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "12345678",
                        null,
                        "Perez",
                        "CMP12345",
                        "Cardiologia"
                )
        );
    }

    @Test
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "12345678",
                        "Juan",
                        null,
                        "CMP12345",
                        "Cardiologia"
                )
        );
    }

    @Test
    void shouldRejectDoctorWithoutTuition() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(
                        "12345678",
                        "Juan",
                        "Perez",
                        null,
                        "Cardiologia"
                )
        );
    }

    @Test
    void shouldReturnAllDoctorAttributes() {
        Doctor doctor = new Doctor(
                "87654321",
                "Maria",
                "Lopez",
                "CMP98765",
                "Pediatria"
        );

        assertEquals("87654321", doctor.getDocumento());
        assertEquals("Maria", doctor.getNombres());
        assertEquals("Lopez", doctor.getApellidos());
        assertEquals("CMP98765", doctor.getColegiatura());
        assertEquals("Pediatria", doctor.getEspecialidad());
    }


}