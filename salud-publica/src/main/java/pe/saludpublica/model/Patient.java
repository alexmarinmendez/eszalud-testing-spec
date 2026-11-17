package pe.saludpublica.model;

public class Patient {

    private String document;
    private String names;
    private String surnames;
    private String phone;
    private String email;

    public Patient(String document, String names, String surnames, String phone, String email) {
        if (document == null || document.isBlank()) {
            throw new IllegalArgumentException("El documento del paciente es obligatorio");
        }
        this.document = document;
        this.names = names;
        this.surnames = surnames;
        this.phone = phone;
        this.email = email;
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
