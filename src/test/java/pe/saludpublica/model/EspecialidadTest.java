package pe.saludpublica.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EspecialidadTest {
    @Test
    @DisplayName("ESP-001 / ESP-003: Crear especialidad con datos válidos y verificar atributos")
    void shouldCreateSpecialtyWithValidData() {
        Especialidad especialidad = new Especialidad("Cardiología", "Atención de enfermedades del corazón");
        assertNotNull(especialidad);
        assertEquals("Cardiología", especialidad.getNombre());
        assertEquals("Atención de enfermedades del corazón", especialidad.getDescripcion());
    }

    @Test
    @DisplayName("ESP-002: Rechazar la creación de una especialidad sin nombre (null)")
    void shouldRejectSpecialtyWithoutName() {
        assertThrows(IllegalArgumentException.class, () -> new Especialidad(null, "Descripción válida"));
    }

    @Test
    @DisplayName("ESP-004 / ESP-005: Rechazar especialidad con nombre vacío o solo espacios")
    void shouldRejectSpecialtyWithBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Especialidad("", "Descripción"));
        assertThrows(IllegalArgumentException.class, () -> new Especialidad("   ", "Descripción"));
    }
}
