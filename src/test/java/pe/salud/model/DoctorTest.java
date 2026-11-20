package pe.salud.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class DoctorTest {
    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor(
                "45678912",
                "Roberto Enrique",
                "Salazar Mendoza",
                "CMP 085432",
                "6af71da3501cca046a166045"
        );

        assertNotNull(doctor);
        assertEquals("45678912", doctor.getDocumento());
        assertEquals("Roberto Enrique", doctor.getNombres());
        assertEquals("Salazar Mendoza", doctor.getApellidos());
        assertEquals("CMP 085432", doctor.getColegiatura());
        assertEquals("6af71da3501cca046a166045", doctor.getEspecialidad());
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor(null, "Roberto Enrique", "Salazar Mendoza", "CMP 085432", "6af71da3501cca046a166045")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutFirstName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("45678912", null, "Salazar Mendoza", "CMP 085432", "6af71da3501cca046a166045")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("45678912", "Roberto Enrique", null, "CMP 085432", "6af71da3501cca046a166045")
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutLicense() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Doctor("45678912", "Roberto Enrique", "Salazar Mendoza", null, "6af71da3501cca046a166045")
        );
    }

}
