package application;

import java.time.LocalDate;

public class Appointment {
    private int id;
    private int patientID;
    private int doctorID;
    private LocalDate date;
    private String allergies;
    private String healthConcern;
    private String physExam;
    private String docConcern;
    private String prescription;

    // Constructor
    public Appointment(int ID, int patientID, int doctorID, LocalDate date, String allergies,
            String healthConcern, String physExam, String docConcern,
            String prescription) {
        this.id = ID;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.date = date;
        this.allergies = allergies;
        this.healthConcern = healthConcern;
        this.physExam = physExam;
        this.docConcern = docConcern;
        this.prescription = prescription;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getHealthConcern() {
        return healthConcern;
    }

    public void setHealthConcern(String healthConcern) {
        this.healthConcern = healthConcern;
    }

    public String getPhysExam() {
        return physExam;
    }

    public void setPhysExam(String physExam) {
        this.physExam = physExam;
    }

    public String getDocConcern() {
        return docConcern;
    }

    public void setDocConcern(String docConcern) {
        this.docConcern = docConcern;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Appointment {" +
                "id=" + id +
                ", patientID=" + patientID +
                ", doctorID=" + doctorID +
                ", date=" + date +
                ", allergies='" + allergies + '\'' +
                ", healthConcern='" + healthConcern + '\'' +
                ", physExam='" + physExam + '\'' +
                ", docConcern='" + docConcern + '\'' +
                ", prescription='" + prescription + '\'' +
                '}';
    }
}
