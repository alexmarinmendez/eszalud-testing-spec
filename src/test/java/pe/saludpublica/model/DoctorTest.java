package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class DoctorTest {

    @Test
    @DisplayName("DOC-001 | Crear doctor con datos válidos")
    void debeCrearDoctorConDatosValidos() {

        Doctor doctor = new Doctor(
                "45678912",
                "Roberto Enrique",
                "Salazar Mendoza",
                "CMP 085432",
                "6af71da3501cca046a166045"
        );

        assertEquals("45678912", doctor.getDocumento());
        assertEquals("Roberto Enrique", doctor.getNombres());
        assertEquals("Salazar Mendoza", doctor.getApellidos());
        assertEquals("CMP 085432", doctor.getColegiatura());
        assertEquals("6af71da3501cca046a166045", doctor.getSpecialtyId());
    }


    @Test
    @DisplayName("DOC-002 | Rechazar doctor con documento nulo")
    void debeRechazarDocumentoNulo() {

        assertThrows(
                IllegalArgumentException.class, () ->
                new Doctor(
                        null,
                        "Roberto Enrique",
                        "Salazar Mendoza",
                        "CMP 085432",
                        "6af71da3501cca046a166045"
                )
        );
    }


    @Test
    @DisplayName("DOC-003  | Rechazar doctor con nombres nulos")
    void debeRechazarNombresNulos() {

        assertThrows(IllegalArgumentException.class, () ->
                new Doctor(
                        "45678912",
                        null,
                        "Salazar Mendoza",
                        "CMP 085432",
                        "6af71da3501cca046a166045"
                )
        );
    }


    @Test
    @DisplayName("DOC-004 | Rechazar doctor con apellidos nulos")
    void debeRechazarApellidosNulos() {

        assertThrows(IllegalArgumentException.class, () ->
                new Doctor(
                        "45678912",
                        "Roberto Enrique",
                        null,
                        "CMP 085432",
                        "6af71da3501cca046a166045"
                )
        );
    }


    @Test
    @DisplayName("DOC-005 | Rechazar doctor con colegiatura nula")
    void debeRechazarColegiaturaNula() {

        assertThrows(IllegalArgumentException.class, () ->
                new Doctor(
                        "45678912",
                        "Roberto Enrique",
                        "Salazar Mendoza",
                        null,
                        "6af71da3501cca046a166045"
                )
        );
    }


    @Test
    @DisplayName("DOC-006: Verificar todos los atributos del doctor")
    void debeVerificarTodosLosAtributosDelDoctor() {

        Doctor doctor = new Doctor(
                "72345681",
                "Patricia Elena",
                "Vargas Ríos",
                "CMP 092718",
                "6af71da3501cca046a166046"
        );

        assertEquals("72345681", doctor.getDocumento());
        assertEquals("Patricia Elena", doctor.getNombres());
        assertEquals("Vargas Ríos", doctor.getApellidos());
        assertEquals("CMP 092718", doctor.getColegiatura());
        assertEquals("6af71da3501cca046a166046", doctor.getSpecialtyId());
    }


}
