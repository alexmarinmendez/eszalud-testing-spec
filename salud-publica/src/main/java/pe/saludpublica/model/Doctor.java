package pe.saludpublica.model;

public class Doctor {

    private String document;
    private String names;
    private String surnames;
    private String licenseNumber;
    private String specialty;

    public Doctor(String document, String names, String surnames, String licenseNumber, String specialty) {
        validateRequired(document, "El documento del doctor es obligatorio");
        this.document = document;
        validateRequired(names, "Los nombres del doctor son obligatorio");
        this.names = names;
        this.surnames = surnames;
        this.licenseNumber = licenseNumber;
        this.specialty = specialty;
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

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getSpecialty() {
        return specialty;
    }
}
