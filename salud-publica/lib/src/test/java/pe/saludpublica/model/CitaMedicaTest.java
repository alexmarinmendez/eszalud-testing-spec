@Test
@DisplayName("Crear cita médica con datos válidos")
void shouldCreateAppointmentWithValidData() {

    CitaMedica cita = new CitaMedica(
            "PAC-001",
            "DOC-001",
            "ESP-001",
            "2026-11-23 16:30",
            "Dolor abdominal",
            EstadoCita.PROGRAMADA
    );

    assertNotNull(cita);

    assertAll(
            () -> assertEquals("PAC-001", cita.getPaciente()),
            () -> assertEquals("DOC-001", cita.getDoctor()),
            () -> assertEquals("ESP-001", cita.getEspecialidad()),
            () -> assertEquals("2026-11-23 16:30", cita.getFechaHora()),
            () -> assertEquals("Dolor abdominal", cita.getMotivo()),
            () -> assertEquals(EstadoCita.PROGRAMADA, cita.getEstado())
    );
}