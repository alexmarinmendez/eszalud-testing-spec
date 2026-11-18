package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DoctorTest {

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
    @DisplayName("Verificar los atributos después de construir el doctor")
    void shouldExposeAllAttributesAfterCreation() {
        Doctor doctor = new Doctor(
                "72345681",
                "Patricia Elena",
                "Vargas Ríos",
                "CMP 092718",
                "6af71da3501cca046a166046"
        );

        assertAll(
                () -> assertEquals("72345681", doctor.getDocumento()),
                () -> assertEquals("Patricia Elena", doctor.getNombres()),
                () -> assertEquals("Vargas Ríos", doctor.getApellidos()),
                () -> assertEquals("CMP 092718", doctor.getColegiatura()),
                () -> assertEquals("6af71da3501cca046a166046", doctor.getEspecialidad())
        );
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin documento")
    void shouldRejectDoctorWithoutDocument() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor(null, "Roberto Enrique", "Salazar Mendoza", "CMP 085432", "6af71da3501cca046a166045"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin nombres")
    void shouldRejectDoctorWithoutFirstNames() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("45678912", null, "Salazar Mendoza", "CMP 085432", "6af71da3501cca046a166045"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin apellidos")
    void shouldRejectDoctorWithoutLastNames() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("45678912", "Roberto Enrique", null, "CMP 085432", "6af71da3501cca046a166045"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin colegiatura")
    void shouldRejectDoctorWithoutMedicalLicense() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("45678912", "Roberto Enrique", "Salazar Mendoza", null, "6af71da3501cca046a166045"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor con documento vacío")
    void shouldRejectDoctorWithBlankDocument() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("", "Roberto Enrique", "Salazar Mendoza", "CMP 085432", "6af71da3501cca046a166045"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor con nombres vacíos")
    void shouldRejectDoctorWithBlankFirstNames() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("45678912", "", "Salazar Mendoza", "CMP 085432", "6af71da3501cca046a166045"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor con apellidos vacíos")
    void shouldRejectDoctorWithBlankLastNames() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("45678912", "Roberto Enrique", "", "CMP 085432", "6af71da3501cca046a166045"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor con colegiatura vacía")
    void shouldRejectDoctorWithBlankMedicalLicense() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("45678912", "Roberto Enrique", "Salazar Mendoza", "", "6af71da3501cca046a166045"));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor sin especialidad asociada")
    void shouldRejectDoctorWithoutSpecialty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("45678912", "Roberto Enrique", "Salazar Mendoza", "CMP 085432", null));
    }

    @Test
    @DisplayName("Rechazar la creación de un doctor con especialidad vacía")
    void shouldRejectDoctorWithBlankSpecialty() {
        assertThrows(IllegalArgumentException.class,
                () -> new Doctor("45678912", "Roberto Enrique", "Salazar Mendoza", "CMP 085432", ""));
    }
}
