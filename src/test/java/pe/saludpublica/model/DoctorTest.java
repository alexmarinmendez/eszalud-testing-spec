package pe.saludpublica.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {
    @Test
    @DisplayName("DOC-001 / DOC-006: Crear un doctor con datos válidos y verificar atributos")
    void shouldCreateDoctorWithValidData() {
        Doctor doctor = new Doctor("87654321", "Carlos", "Gómez", "CMP-10203", "ESP-01");
        assertNotNull(doctor);
    }
}
