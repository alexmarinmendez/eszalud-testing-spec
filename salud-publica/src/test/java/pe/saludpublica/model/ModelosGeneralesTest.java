package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Pruebas generales de la capa Model")
class ModelosGeneralesTest {

    // GEN-002 (recomendada, regla documentada en DECISIONES.md)
    @ParameterizedTest(name = "{0} es inmutable")
    @ValueSource(classes = {Paciente.class, Doctor.class, Especialidad.class, CitaMedica.class})
    @DisplayName("Verificar que los modelos no exponen setters y sus atributos son finales")
    void shouldBeImmutableWhenModelIsCreated(Class<?> modelo) {
        boolean tieneSetters = Arrays.stream(modelo.getMethods())
                .map(Method::getName)
                .anyMatch(nombre -> nombre.startsWith("set"));

        boolean atributosFinales = Arrays.stream(modelo.getDeclaredFields())
                .filter(campo -> !Modifier.isStatic(campo.getModifiers()))
                .map(Field::getModifiers)
                .allMatch(Modifier::isFinal);

        assertAll(
                () -> assertFalse(tieneSetters, "no debe tener setters"),
                () -> assertTrue(atributosFinales, "todos sus atributos deben ser final")
        );
    }

    // GEN-003 (recomendada)
    @Test
    @DisplayName("Crear dos objetos con información diferente sin que interfieran entre sí")
    void shouldKeepIndependentDataWhenCreatingDifferentObjects() {
        Paciente primero = new Paciente("11111111", "Ana", "Pérez", "911111111", "ana@mail.com");
        Paciente segundo = new Paciente("22222222", "Luis", "Gómez", "922222222", "luis@mail.com");

        CitaMedica primeraCita = new CitaMedica("pac-001", "doc-001", "esp-001",
                LocalDateTime.of(2026, 12, 15, 9, 30), "Control", EstadoCita.PROGRAMADA);
        CitaMedica segundaCita = new CitaMedica("pac-002", "doc-002", "esp-002",
                LocalDateTime.of(2026, 12, 16, 10, 0), "Evaluación", EstadoCita.CANCELADA);

        assertAll(
                () -> assertEquals("11111111", primero.getDocumento(), "documento del primer paciente"),
                () -> assertEquals("Ana", primero.getNombres(), "nombres del primer paciente"),
                () -> assertEquals("22222222", segundo.getDocumento(), "documento del segundo paciente"),
                () -> assertEquals("Luis", segundo.getNombres(), "nombres del segundo paciente"),
                () -> assertEquals("pac-001", primeraCita.getPaciente(), "paciente de la primera cita"),
                () -> assertEquals(EstadoCita.PROGRAMADA, primeraCita.getEstado(), "estado de la primera cita"),
                () -> assertEquals("pac-002", segundaCita.getPaciente(), "paciente de la segunda cita"),
                () -> assertEquals(EstadoCita.CANCELADA, segundaCita.getEstado(), "estado de la segunda cita")
        );
    }
}