package pe.saludpublica.model;

public class Patient {

    private String document;
    private String names;
    private String surnames;
    private String phone;
    private String email;

    public Patient(String document, String names, String surnames, String phone, String email) {
        validateRequired(document, "El documento del paciente es obligatorio");
        this.document = document;
        validateRequired(names, "Los nombres del paciente son obligatorios");
        this.names = names;
        validateRequired(surnames, "Los apellidos del paciente son obligatorios");
        this.surnames = surnames;
        this.phone = phone;
        this.email = email;
    }

    private static void validateRequired(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public String getDocument() {
        return document;
    }

    public String getNames() {
        return names;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
