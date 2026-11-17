package pe.saludpublica.model;

public class Doctor {

    private String document;
    private String names;
    private String surnames;
    private String licenseNumber;
    private String specialty;

    public Doctor(String document, String names, String surnames, String licenseNumber, String specialty) {
        this.document = document;
        this.names = names;
        this.surnames = surnames;
        this.licenseNumber = licenseNumber;
        this.specialty = specialty;
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
